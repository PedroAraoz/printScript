package edu.austral.ingsis;

public class MultDivOperationSyntaxBranch extends AbstractSyntaxBranch {
    @Override
    public AbstractSyntaxTree add(AbstractSyntaxTree tree) {
        return tree.addMultDivOperationSyntaxTree(this);
    }

    @Override
    public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
        return branch.addMultDivOperationSyntaxTree(this);
    }

    @Override
    public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {
        return branch.addMultDivOperationSyntaxTree(this);
    }

    @Override
    public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
        if (!right.isEmpty() && !left.isEmpty()) {
            branch.addMultDivOperationSyntaxTree(this);
        }
        return this;
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
        if (right.isEmpty()) {
            right = leaf;
        } else if (left.isEmpty()) {
            left = leaf;
        } else {
            //Explode
        }
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
