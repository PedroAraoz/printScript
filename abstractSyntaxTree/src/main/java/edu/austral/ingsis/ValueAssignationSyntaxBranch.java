package edu.austral.ingsis;

public class ValueAssignationSyntaxBranch extends AbstractSyntaxBranch{
    @Override
    public void add(AbstractSyntaxTree tree) {
        tree.addValueAsignationSyntaxTree(this);
    }

    @Override
    public void addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
        //TODO ERROR
    }

    @Override
    public void addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
        addLeft(branch);
    }

    @Override
    public void addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {
        addRight(branch);
    }

    @Override
    public void addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
        addRight(branch);
    }

    @Override
    public void addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) {
        addLeft(leaf);
    }

    @Override
    public void addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) {
        addLeft(leaf);
    }

    @Override
    public void addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) {
        addLeft(leaf);
    }

    @Override
    public void addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) {
        addRight(leaf);
    }

    @Override
    public void addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {

    }

    @Override
    public void accept(Visitor visitor) {

    }
}
