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
        branch.addMultDivOperationSyntaxTree(this);
    }

    @Override
    public void addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
        if (!right.isEmpty() && !left.isEmpty()) {
            branch.addMultDivOperationSyntaxTree(this);
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
