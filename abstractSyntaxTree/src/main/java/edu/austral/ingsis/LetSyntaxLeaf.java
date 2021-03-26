package edu.austral.ingsis;

public class LetSyntaxLeaf extends AbstractSyntaxLeaf{
    @Override
    public void add(AbstractSyntaxTree tree) {
        tree.addLetSyntaxLeaf(this);
    }

    @Override
    public void addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {

    }

    @Override
    public void addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {

    }

    @Override
    public void addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {

    }

    @Override
    public void addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
    }

    @Override
    public void addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) {

    }

    @Override
    public void addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) {

    }

    @Override
    public void addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) {

    }

    @Override
    public void addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) {

    }

    @Override
    public void addLetSyntaxLeaf(LetSyntaxLeaf leaf) {

    }

    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
