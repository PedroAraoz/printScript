package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class LeftParenthesisSyntaxLeaf extends AbstractSyntaxLeaf {

    private AbstractSyntaxTree expression = new EmptySyntaxLeaf();

    @Override
    public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
        return tree.addLeftParenthesisSyntaxLeaf(this);
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
        return leaf.addLeftParenthesisSyntaxLeaf(this);
    }

    @Override
    public AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf) {
        this.expression = leaf.getResultingExpression();
        return this;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLeftParenthesis(this);
    }

    public AbstractSyntaxTree getResultingExpression() {
        return expression;
    }
}
