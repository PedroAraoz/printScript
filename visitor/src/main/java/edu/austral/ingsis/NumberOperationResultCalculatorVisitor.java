package edu.austral.ingsis;

import java.util.Stack;

public class NumberOperationResultCalculatorVisitor implements Visitor {

    private final VariableRegister variableRegister;
    private final Stack<Double> accumulator = new Stack<>();

    public NumberOperationResultCalculatorVisitor(VariableRegister variableRegister) {

        this.variableRegister = variableRegister;
    }

    public double getResult() {
        return accumulator.peek();
    }

    @Override
    public void visit(AbstractSyntaxTree abstractSyntaxTree) {

    }

    @Override
    public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {

    }

    @Override
    public void visitTypeAssingation(TypeAssignationSyntaxBranch branch) {

    }

    @Override
    public void visitSumSub(SumSubOperationSyntaxBranch branch) {
        if (branch.getToken().getTokenIdentifier().equals(TokenIdentifier.SUM_OPERATION_TOKEN)) {
            Double val1 = accumulator.pop();
            Double val2 = accumulator.pop();
            Double result = val2 + val1;
            accumulator.push(result);
        } else {
            Double val1 = accumulator.pop();
            Double val2 = accumulator.pop();
            Double result = val2 - val1;
            accumulator.push(result);
        }
    }

    @Override
    public void visitMultDiv(MultDivOperationSyntaxBranch branch) {
        if (branch.getToken().getTokenIdentifier().equals(TokenIdentifier.MULT_OPERATION_TOKEN)) {
            Double val1 = accumulator.pop();
            Double val2 = accumulator.pop();
            Double result = val2 * val1;
            accumulator.push(result);
        } else {
            Double val1 = accumulator.pop();
            Double val2 = accumulator.pop();
            Double result = val2 / val1;
            accumulator.push(result);
        }
    }

    @Override
    public void visitNumberType(NumberTypeSyntaxLeaf leaf) {

    }

    @Override
    public void visitStringType(StringTypeSyntaxLeaf leaf) {

    }

    @Override
    public void visitVariable(VariableSyntaxLeaf leaf) {
        String value = variableRegister.get(leaf.getToken().getValue()).get().getValue();
        accumulator.push(Double.parseDouble(value));
    }

    @Override
    public void visitLiteral(LiteralSyntaxLeaf leaf) {
        String value = leaf.getToken().getValue();
        accumulator.push(Double.parseDouble(value));
    }

    @Override
    public void visitEmpty(EmptySyntaxLeaf leaf) {

    }

    @Override
    public void visitPrintLn(PrintLnSyntaxLeaf leaf) {

    }

    @Override
    public void visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf) {

    }

    @Override
    public void visitRightParenthesis(RightParenthesisSyntaxLeaf leaf) {

    }
}
