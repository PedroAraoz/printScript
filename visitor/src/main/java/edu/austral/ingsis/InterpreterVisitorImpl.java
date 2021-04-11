package edu.austral.ingsis;

public class InterpreterVisitorImpl implements InterpreterVisitor {

    private final VariableRegister variableRegister = new VariableRegister();

    @Override
    public AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree) {
        return abstractSyntaxTree.accept2(this);
    }

    @Override
    public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {
        VariableSyntaxLeaf variableSyntaxLeaf = (VariableSyntaxLeaf) visit(branch.left);
        LiteralSyntaxLeaf literalSyntaxLeaf = (LiteralSyntaxLeaf) visit(branch.right);

        // TODO conseguir el tipo del literal
        variableRegister.assignValueToVariable(variableSyntaxLeaf.getTokenWrapper().getValue(), literalSyntaxLeaf.getTokenWrapper().getValue());
    }

    @Override
    public VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch) {
        String variableName = branch.left.getTokenWrapper().getValue();
        Token type = branch.right.getTokenWrapper().getToken();

        variableRegister.addNewVariable(variableName, type);

        return (VariableSyntaxLeaf) branch.left;
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
}
