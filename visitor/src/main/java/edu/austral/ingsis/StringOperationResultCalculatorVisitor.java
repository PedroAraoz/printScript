//package edu.austral.ingsis;
//
//import java.util.Stack;
//
//public class StringOperationResultCalculatorVisitor implements Visitor {
//
//    private final VariableRegister variableRegister;
//    Stack<String> accumulator = new Stack<>();
//
//    public StringOperationResultCalculatorVisitor(VariableRegister variableRegister) {
//        this.variableRegister = variableRegister;
//    }
//
//    public String getResult() {
//        return accumulator.pop();
//    }
//
//    @Override
//    public void visit(AbstractSyntaxTree abstractSyntaxTree) {
//
//    }
//
//    @Override
//    public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {
//
//    }
//
//    @Override
//    public void visitTypeAssingation(TypeAssignationSyntaxBranch branch) {
//
//    }
//
//    @Override
//    public void visitSumSub(SumSubOperationSyntaxBranch branch) {
//        String val1 = accumulator.pop();
//        String val2 = accumulator.pop();
//        String result = val2 + val1;
//        accumulator.push(result);
//    }
//
//    @Override
//    public void visitMultDiv(MultDivOperationSyntaxBranch branch) {
//
//    }
//
//    @Override
//    public void visitNumberType(NumberTypeSyntaxLeaf leaf) {
//
//    }
//
//    @Override
//    public void visitStringType(StringTypeSyntaxLeaf leaf) {
//
//    }
//
//    @Override
//    public void visitVariable(VariableSyntaxLeaf leaf) {
//        String value = variableRegister.get(leaf.getToken().getValue()).get().getValue();
//        accumulator.push(value);
//    }
//
//    @Override
//    public void visitLiteral(LiteralSyntaxLeaf leaf) {
//        String value = leaf.getToken().getValue();
//        accumulator.push(value);
//    }
//
//    @Override
//    public void visitEmpty(EmptySyntaxLeaf leaf) {
//
//    }
//
//    @Override
//    public void visitPrintLn(PrintLnSyntaxLeaf leaf) {
//
//    }
//
//    @Override
//    public void visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf) {
//
//    }
//
//    @Override
//    public void visitRightParenthesis(RightParenthesisSyntaxLeaf leaf) {
//
//    }
//}
