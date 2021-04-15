//package edu.austral.ingsis.validator;
//
//import edu.austral.ingsis.*;
//import edu.austral.ingsis.exception.CompilationTimeException;
//
//import java.util.Optional;
//
//public class AssignationVariableExistsValidator implements Validator {
//
//    /*
//    * This validator checks if the varible in which the values are being assigned to exists
//     */
//
//    private VariableRegister register;
//
//    public AssignationVariableExistsValidator(VariableRegister register) {
//        this.register = register;
//    }
//
//    @Override
//    public void validate(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException {
//        ValueAssignationFinderVisitor visitor = new ValueAssignationFinderVisitor();
//        abstractSyntaxTree.accept(visitor);
//        Optional<ValueAssignationSyntaxBranch> valueAssignationSyntaxBranch = visitor.getValueAssignation();
//
//        TypeAssignationFinderVisitor typeVisitor = new TypeAssignationFinderVisitor();
//        abstractSyntaxTree.accept(typeVisitor);
//        Optional<TypeAssignationSyntaxBranch> typeAssignationBranch = typeVisitor.getTypeAssignation();
//
//        if (valueAssignationSyntaxBranch.isPresent() && !typeAssignationBranch.isPresent()) {
//
//            VariableFinderVisitor variableFinderVisitor = new VariableFinderVisitor();
//            valueAssignationSyntaxBranch.get().accept(variableFinderVisitor);
//
//            Token variable = variableFinderVisitor.getVariable().get();
//
//            if (!register.contains(variable.getValue())) {
//                throw new CompilationTimeException("Undeclared variable " + variable.getValue() + " in line " + variable.getLine() + " column " + variable.getStartPos());
//            } else {
//                // OK
//            }
//        }
//    }
//}
