package edu.austral.ingsis;

import edu.austral.ingsis.*;

public class EmptyValidatorVisitor implements Visitor{

    private boolean foundEmpty = false;

    @Override
    public void visit(AbstractSyntaxTree abstractSyntaxTree) {
        abstractSyntaxTree.accept(this);
    }

    @Override
    public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {

    }

    @Override
    public void visitTypeAssingation(TypeAssignationSyntaxBranch branch) {

    }

    @Override
    public void visitSumSub(SumSubOperationSyntaxBranch branch) {

    }

    @Override
    public void visitMultDiv(MultDivOperationSyntaxBranch branch) {

    }

    @Override
    public void visitNumberType(NumberTypeSyntaxLeaf leaf) {

    }

    @Override
    public void visitStringType(StringTypeSyntaxLeaf leaf) {

    }

    @Override
    public void visitVariable(VariableSyntaxLeaf leaf) {

    }

    @Override
    public void visitLiteral(LiteralSyntaxLeaf leaf) {

    }

    @Override
    public void visitEmpty(EmptySyntaxLeaf leaf) {
        foundEmpty = true;
    }

    public boolean foundEmpty() {
        return foundEmpty;
    }
}
