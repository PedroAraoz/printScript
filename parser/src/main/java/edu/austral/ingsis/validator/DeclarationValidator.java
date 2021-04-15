//package edu.austral.ingsis.validator;
//
//import edu.austral.ingsis.AbstractSyntaxTree;
//import edu.austral.ingsis.Token;
//import edu.austral.ingsis.TypeAssignationSyntaxBranch;
//import edu.austral.ingsis.exception.CompilationTimeException;
//import edu.austral.ingsis.TypeAssignationFinderVisitor;
//import edu.austral.ingsis.VariableFinderVisitor;
//
//import java.util.Optional;
//
//public class DeclarationValidator implements Validator {
//
//    /*
//     * This Validator checks that initialized variables are not initialized twice
//     */
//
//    private final VariableRegister register;
//
//    public DeclarationValidator(VariableRegister register) {
//        this.register = register;
//    }
//
//    @Override
//    public void validate(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException {
//
//        TypeAssignationFinderVisitor visitor = new TypeAssignationFinderVisitor();
//        abstractSyntaxTree.accept(visitor);
//        Optional<TypeAssignationSyntaxBranch> typeAssignationSyntaxBranch = visitor.getTypeAssignation();
//
//        if (typeAssignationSyntaxBranch.isPresent()) {
//
//            VariableFinderVisitor variableFinderVisitor = new VariableFinderVisitor();
//            typeAssignationSyntaxBranch.get().accept(variableFinderVisitor);
//
//            Token variable = variableFinderVisitor.getVariable().get();
//
//            if (register.contains(variable.getValue())) {
//                throw new CompilationTimeException("Variable " + variable.getValue() + " in line " + variable.getLine() + " column " + variable.getStartPos() + " is already initialized");
//            } else {
//                // OK
//            }
//
//        }
//    }
//}
