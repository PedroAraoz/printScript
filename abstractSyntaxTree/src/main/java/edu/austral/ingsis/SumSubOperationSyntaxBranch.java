package edu.austral.ingsis;

public class SumSubOperationSyntaxBranch extends AbstractSyntaxBranch{
    @Override
    public void add(AbstractSyntaxTree tree) {
        tree.addSumSubOperationSyntaxTree(this);
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
    public void addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {

    }

    @Override
    public void accept(Visitor visitor) {

    }
}
