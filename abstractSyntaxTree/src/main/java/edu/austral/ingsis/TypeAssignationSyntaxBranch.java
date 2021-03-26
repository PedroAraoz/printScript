package edu.austral.ingsis;

public class TypeAssignationSyntaxBranch extends AbstractSyntaxBranch{
    @Override
    public void add(AbstractSyntaxTree tree) {
        tree.addTypeAsignationSyntaxTree(this);
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
        if (!right.isEmpty()) {
            right = leaf;
        } else {
            //EXplode
        }
    }

    @Override
    public void addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) {
        if (!right.isEmpty()) {
            right = leaf;
        } else {
            //EXplode
        }
    }

    @Override
    public void addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) {
        if (!left.isEmpty()) {
            left = leaf;
        } else {
            //EXplode
        }
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
