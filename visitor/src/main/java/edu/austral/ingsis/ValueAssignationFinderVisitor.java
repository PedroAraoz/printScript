package edu.austral.ingsis;

import java.util.Optional;

public class ValueAssignationFinderVisitor implements Visitor {

    private Optional<ValueAssignationSyntaxBranch> valueAssignation = Optional.empty();

    public Optional<ValueAssignationSyntaxBranch> getValueAssignation() {
        return this.valueAssignation;
    }

    @Override
    public void visit(AbstractSyntaxTree abstractSyntaxTree) {

    }

    @Override
    public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {
        this.valueAssignation = Optional.of(branch);
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

    }

    @Override
    public void visitPrintLn(PrintLnSyntaxLeaf leaf) {

    }

    @Override
    public void visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf) {

    }

    @Override
    public void visitRightParenthesis(RightParenthesisSyntaxLeaf leaf) {

    }

    @Override
    public void visitBooleanType(BooleanTypeSyntaxLeaf leaf) {

    }

    @Override
    public void visitGreaterThan(GreaterThanOperationSyntaxBranch branch) {

    }

    @Override
    public void visitLesserThan(LesserThanOperationSyntaxBranch branch) {

    }

    @Override
    public void visitLesserEqualThan(LesserEqualThanOperationSyntaxBranch branch) {

    }

    @Override
    public void visitGreaterEqualThan(GreaterEqualThanOperationSyntaxBranch branch) {

    }

    @Override
    public void visitLeftBracket(LeftBracketSyntaxLeaf leaf) {

    }

    @Override
    public void visitRightBracket(RightBracketSyntaxLeaf leaf) {

    }

    @Override
    public void visitIf(IfOperationSyntaxBranch branch) {

    }

    @Override
    public void visitConst(ConstSyntaxLeaf constSyntaxLeaf) {

    }
}
