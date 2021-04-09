package edu.austral.ingsis.validator;

import edu.austral.ingsis.*;
import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AssignationTypeValidator implements Validator {

    /*
    * This Validator checks that assigned values match the variable type they are assigned to
     */

    private final VariableRegister register;

    public AssignationTypeValidator(VariableRegister register) {
        this.register = register;
    }

    @Override
    public void validate(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException {
        ValueAssignationFinderVisitor visitor = new ValueAssignationFinderVisitor();
        abstractSyntaxTree.accept(visitor);
        Optional<ValueAssignationSyntaxBranch> valueAssignationSyntaxBranch = visitor.getValueAssignation();

        if (valueAssignationSyntaxBranch.isPresent()) {
            // If there is a value assignation there are two options.
            // It either is a declaration + assignation -> Check type = assignation type
            // Or it is simply an assignation -> Check type in register = assignation type

            VariableFinderVisitor variableFinderVisitor = new VariableFinderVisitor();
            valueAssignationSyntaxBranch.get().accept(variableFinderVisitor);

            TokenWrapper variable = variableFinderVisitor.getVariable().get();

            TypeAssignationFinderVisitor typeAssignationFinderVisitor = new TypeAssignationFinderVisitor();
            abstractSyntaxTree.accept(typeAssignationFinderVisitor);
            Optional<TypeAssignationSyntaxBranch> typeAssignationSyntaxBranch = typeAssignationFinderVisitor.getTypeAssignation();

            List<TokenWrapper> variablesToCheck = getVariablesToCheck(abstractSyntaxTree, typeAssignationSyntaxBranch);

            Token assignationType = checkAssignationType(abstractSyntaxTree, variablesToCheck);

            if (typeAssignationSyntaxBranch.isPresent()) {
                // In this case it is a declaration + assignation
                // Should check declaration type = assignation type

                // Check that declaration type is the same as all of the rest
                if (!typeAssignationFinderVisitor.getTypeAssignation().get().getTokenWrapper().getToken().equals(assignationType)) {
                    throw new CompilationTimeException("Assignation type does not match declaration type in line " + variable.getLine() + " in column " + variable.getStartPos());
                }

            } else {
                // In this case it is simply an assignation
                // Should check type in register = assignation type
                Optional<VariableInfo> variableInfo = register.get(variable.getValue());
                if (!variableInfo.isPresent()) {
                    throw new RuntimeException("Variable was declared but was not found");
                }
                if (!variableInfo.get().getType().equals(assignationType)) {
                    throw new CompilationTimeException("Type mismatch: cannot assign to variable in line " + variable.getLine() + " in column " + variable.getStartPos());
                }
            }
        }
    }

    private Token checkAssignationType(AbstractSyntaxTree abstractSyntaxTree, List<TokenWrapper> variables) throws CompilationTimeException {
        // Assignation type

        // Check that variables in the assignation are of the same type

        if (!variables.isEmpty()) {
            // Check they exist
            for (TokenWrapper var : variables) {
                if (!register.contains(var.getValue())) {
                    throw new CompilationTimeException("Undeclared variable in line " + var.getLine() + " in column " + var.getStartPos());
                }
            }

            // Check their types are the same
            Token type = null;
            for (TokenWrapper var : variables) {
                if (type == null) {
                    type = var.getToken();
                } else {
                    if (!var.getToken().equals(type)) {
                        throw new CompilationTimeException("Variable " + var.getValue() + " does not match the type of the expression in line " + var.getLine() + " in column " + var.getStartPos());
                    }
                }
            }
        }

        // Check that literals in the assignation are of the same type
        AssignationLiteralTypeVisitor assignationLiteralTypeVisitor = new AssignationLiteralTypeVisitor();
        abstractSyntaxTree.accept(assignationLiteralTypeVisitor);

        if (!assignationLiteralTypeVisitor.matches()) {
            // TODO Add line and column
            throw new CompilationTimeException("Type mismatch in assignation");
        }

        // Check that variables and literals are of the same type
        Token varType;
        if (!variables.isEmpty()) {
            varType = variables.get(0).getToken();
            if (!varType.equals(assignationLiteralTypeVisitor.getType())) {
                throw new CompilationTimeException("Variables and literals do not match type in assignation in line " + variables.get(0).getLine());
            }
        }

        // TODO problema si no hay literals
        return assignationLiteralTypeVisitor.getType();
    }

    private List<TokenWrapper> getVariablesToCheck(AbstractSyntaxTree abstractSyntaxTree, Optional<TypeAssignationSyntaxBranch> branch) {
        GetAllVariablesVisitor getAllVariablesVisitor = new GetAllVariablesVisitor();
        abstractSyntaxTree.accept(getAllVariablesVisitor);
        List<TokenWrapper> variables = getAllVariablesVisitor.getAllVariables();

        if (branch.isPresent()) {
            String leftVarName = branch.get().getLeft().getTokenWrapper().getValue();
            variables = variables.stream().filter(tw -> !tw.getValue().equals(leftVarName)).collect(Collectors.toList());
        }

        return variables;
    }
}
