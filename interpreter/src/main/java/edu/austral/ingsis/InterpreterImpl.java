package edu.austral.ingsis;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InterpreterImpl implements Interpreter {
//
//    private final List<Executer> executers;
//
//    public InterpreterImpl(VariableRegister variableRegister) {
//        executers = new ArrayList<>();
//        executers.add(new DeclarationExecuter(variableRegister));
//        executers.add(new AssignationExecuter(variableRegister));
//    }
//
//    @Override
//    public List<String> interpret(AbstractSyntaxTree ast) {
//        List<String> progressInfo = new ArrayList<>();
//        for (Executer executer : executers) {
//            progressInfo.addAll(executer.execute(ast));
//        }
//        return progressInfo;
//    }
//}
