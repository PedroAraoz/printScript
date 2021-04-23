package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class PrintLnSyntaxLeaf extends AbstractSyntaxLeaf {

    private AbstractSyntaxTree innerExpression;

    @Override
    public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
        return tree.addPrintLnSyntaxLeaf(this);
    }

    @Override
    public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) throws CompilationTimeException {
        return null;
    }

    @Override
    public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) throws CompilationTimeException {
        return null;
    }

    @Override
    public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) throws CompilationTimeException {
        return null;
    }

    @Override
    public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) throws CompilationTimeException {
        return null;
    }

    @Override
    public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) throws CompilationTimeException {
        return null;
    }

    @Override
    public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) throws CompilationTimeException {
        return null;
    }

    @Override
    public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) throws CompilationTimeException {
        return null;
    }

    @Override
    public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) throws CompilationTimeException {
        return null;
    }

    @Override
    public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
        return this;
    }

    @Override
    public AbstractSyntaxTree addPrintLnSyntaxLeaf(PrintLnSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf) {
        this.innerExpression = leaf.getResultingExpression();
        return this;
    }

    @Override
    public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addBooleanTypeSyntaxLeaf(BooleanTypeSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addGreaterThanOperationSyntaxBranch(GreaterThanOperationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addLesserThanOperationSyntaxBranch(LesserThanOperationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addLesserEqualThanOperationSyntaxBranch(LesserEqualThanOperationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addGreaterEqualThanOperationSyntaxBranch(GreaterEqualThanOperationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addIfOperationSyntaxBranch(IfOperationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addConstSyntaxLeaf(ConstSyntaxLeaf leaf) throws CompilationTimeException {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPrintLn(this);
    }

    @Override
    public AbstractSyntaxTree accept2(InterpreterVisitor visitor) throws CompilationTimeException {
        return visitor.visitPrintLn(this);
    }

    public AbstractSyntaxTree getExpression() {
        return innerExpression;
    }
}
