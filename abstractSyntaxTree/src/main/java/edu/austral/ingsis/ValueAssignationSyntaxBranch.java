package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class ValueAssignationSyntaxBranch extends AbstractSyntaxBranch {

    @Override
    public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
        return tree.addValueAsignationSyntaxTree(this);
    }

    @Override
    public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) throws CompilationTimeException {
        throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
    }

    @Override
    public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) throws CompilationTimeException {
        addLeft(branch);
        return this;
    }

    @Override
    public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) throws CompilationTimeException {

        addRight(branch);
        return this;
    }

    @Override
    public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) throws CompilationTimeException {

        addRight(branch);
        return this;
    }

    @Override
    public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) throws CompilationTimeException {

        addLeft(leaf);
        return this;
    }

    @Override
    public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) throws CompilationTimeException {

        addLeft(leaf);
        return this;
    }

    @Override
    public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) throws CompilationTimeException {
        addLeft(leaf);
        return this;
    }

    @Override
    public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) throws CompilationTimeException {
        addRight(leaf);
        return this;
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
        return null;
    }

    @Override
    public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        left.accept(visitor);
        right.accept(visitor);
        visitor.visitValueAssignation(this);
    }
    
    @Override
    public AbstractSyntaxTree accept2(InterpreterVisitor visitor) {
        return visitor.visitValueAssignation(this);
    }
}
