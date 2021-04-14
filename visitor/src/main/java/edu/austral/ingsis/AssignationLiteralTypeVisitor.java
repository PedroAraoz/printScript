package edu.austral.ingsis;

public class AssignationLiteralTypeVisitor implements Visitor {

    private TokenIdentifier type = null;
    private boolean match = true;

    public TokenIdentifier getType() {
        return type;
    }

    public boolean matches() {
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
        if (type == null)
            type = leaf.getToken().getTokenIdentifier();
        else if (!leaf.getToken().getTokenIdentifier().equals(type)) {
            match = false;
        }
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
}
