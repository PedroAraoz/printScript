package edu.austral.ingsis.validator;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.TokenWrapper;
import edu.austral.ingsis.ValueAssignationSyntaxBranch;
import edu.austral.ingsis.VariableRegister;
import edu.austral.ingsis.exception.CompilationTimeException;
import edu.austral.ingsis.visitor.ValueAssignationFinderVisitor;
import edu.austral.ingsis.visitor.VariableFinderVisitor;

import java.util.Optional;

public class AssignationTypeValidator implements Validator {

    /*
    * This Validator checks that assigned values match the variable type they are assigned to
     */

    private VariableRegister register;

    public AssignationTypeValidator(VariableRegister register) {
        this.register = register;
    }

    @Override
    public void validate(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException {
        ValueAssignationFinderVisitor visitor = new ValueAssignationFinderVisitor();
        abstractSyntaxTree.accept(visitor);
        Optional<ValueAssignationSyntaxBranch> valueAssignationSyntaxBranch = visitor.getValueAssignation();

        if (valueAssignationSyntaxBranch.isPresent()) {

            VariableFinderVisitor variableFinderVisitor = new VariableFinderVisitor();
            valueAssignationSyntaxBranch.get().accept(variableFinderVisitor);

            TokenWrapper variable = variableFinderVisitor.getVariable().get();

            // Tenemos un problema para chequear esto que es que no diferenciamos entre literals numericos y literals de strings

        }
    }
}
