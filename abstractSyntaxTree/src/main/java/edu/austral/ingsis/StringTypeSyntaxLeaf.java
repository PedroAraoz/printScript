package edu.austral.ingsis;

public class StringTypeSyntaxLeaf extends AbstractSyntaxLeaf{
    @Override
    public void add(AbstractSyntaxTree tree) {
        tree.addStringTypeSyntaxLeaf(this);
    }

    @Override
    public void addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {

    }

    @Override
    public void addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
        branch.addStringTypeSyntaxLeaf(this);
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
}
