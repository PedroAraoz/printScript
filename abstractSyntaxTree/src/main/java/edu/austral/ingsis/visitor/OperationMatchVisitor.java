package edu.austral.ingsis.visitor;

import edu.austral.ingsis.*;

public class OperationMatchVisitor implements Visitor {

    private boolean match = true;

    public boolean match() {
        return match;
    }

    @Override
    public void visit(AbstractSyntaxTree abstractSyntaxTree) {

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
        //leaf.getTokenWrapper().gettype();
    }

    @Override
    public void visitEmpty(EmptySyntaxLeaf leaf) {

    }
}
