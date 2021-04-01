package edu.austral.ingsis;

public class SumSubOperationSyntaxBranch extends AbstractSyntaxBranch{
    @Override
    public AbstractSyntaxTree add(AbstractSyntaxTree tree) {
        return tree.addSumSubOperationSyntaxTree(this);
    }

    @Override
    public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
        return branch.addSumSubOperationSyntaxTree(this);
    }

    @Override
    public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {
        if (right.isEmpty()) {
            right = branch;
        }
        else if (left.isEmpty()) {
            left = branch;
        }
        else {
            branch.addSumSubOperationSyntaxTree(branch);
        }
        return this;
    }

    @Override
    public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
        if (right.isEmpty()) {
            right = branch;
        } else if (left.isEmpty()) {
            left = branch;
        } else {
            //Explode
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
