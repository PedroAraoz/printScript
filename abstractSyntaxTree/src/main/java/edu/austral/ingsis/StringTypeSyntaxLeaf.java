package edu.austral.ingsis;

public class StringTypeSyntaxLeaf extends AbstractSyntaxLeaf{
    @Override
    public AbstractSyntaxTree add(AbstractSyntaxTree tree) {
        return tree.addStringTypeSyntaxLeaf(this);
    }

    @Override
    public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
        return branch.addStringTypeSyntaxLeaf(this);
    }

    @Override
    public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
