package edu.austral.ingsis;

import java.util.Optional;

public class TypeAssignationFinderVisitor implements Visitor {

    private Optional<TypeAssignationSyntaxBranch> typeAsignation = Optional.empty();

    public Optional<TypeAssignationSyntaxBranch> getTypeAssignation() {
        return typeAsignation;
    }

    @Override
    public void visit(AbstractSyntaxTree abstractSyntaxTree) {

    }

    @Override
    public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {

    }

    @Override
    public void visitTypeAssingation(TypeAssignationSyntaxBranch branch) {
        this.typeAsignation = Optional.of(branch);
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
    public void visitIf(IfOperationSyntaxBranch branch) {

    }

    @Override
    public void visitConst(ConstSyntaxLeaf constSyntaxLeaf) {

    }
}
