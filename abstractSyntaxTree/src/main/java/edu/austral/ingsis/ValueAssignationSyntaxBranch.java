package edu.austral.ingsis;

public class ValueAssignationSyntaxBranch extends AbstractSyntaxBranch{
    @Override
    public AbstractSyntaxTree add(AbstractSyntaxTree tree) {
        return tree.addValueAsignationSyntaxTree(this);
    }

    @Override
    public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
        addLeft(branch);
        return this;
    }

    @Override
    public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {

        addRight(branch);
        return this;
    }

    @Override
    public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {

        addRight(branch);
        return this;
    }

    @Override
    public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) {

        addLeft(leaf);
        return this;
    }

    @Override
    public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) {

        addLeft(leaf);
        return this;
    }

    @Override
    public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) {
        addLeft(leaf);
        return this;
    }

    @Override
    public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) {
        addRight(leaf);
        return this;
    }

    @Override
    public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
