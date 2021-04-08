package edu.austral.ingsis.visitor;

import edu.austral.ingsis.*;

import java.util.Optional;

public class VariableFinderVisitor implements Visitor {

    private Optional<TokenWrapper> variable = Optional.empty();

    public Optional<TokenWrapper> getVariable() {
        return variable;
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
        variable = Optional.of(leaf.getTokenWrapper());
    }

    @Override
    public void visitLiteral(LiteralSyntaxLeaf leaf) {

    }

    @Override
    public void visitEmpty(EmptySyntaxLeaf leaf) {

    }
}
