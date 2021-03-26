package edu.austral.ingsis;

public class MultDivOperationSyntaxBranch extends AbstractSyntaxBranch {
    @Override
    public void add(AbstractSyntaxTree tree) {
        tree.addMultDivOperationSyntaxTree(this);
    }

    @Override
    public void addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
        branch.addMultDivOperationSyntaxTree(this);
    }

    @Override
    public void addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
        //ERROR
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
