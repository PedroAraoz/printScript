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
        if (!right.isEmpty() && !left.isEmpty()) {
            branch.addSumSubOperationSyntaxTree(this);
        }
    }

    @Override
    public void addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
        if (right.isEmpty()) {
            right = branch;
        } else if (left.isEmpty()) {
            left = branch;
        } else {
            //Explode
        }
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
        if (right.isEmpty()) {
            right = leaf;
        } else if (left.isEmpty()) {
            left = leaf;
        } else {
            //Explode
        }
    }

    @Override
    public void addLetSyntaxLeaf(LetSyntaxLeaf leaf) {

    }

    @Override
    public void accept(Visitor visitor) {

    }
}
