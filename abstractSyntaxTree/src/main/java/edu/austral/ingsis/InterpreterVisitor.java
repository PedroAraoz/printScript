package edu.austral.ingsis;

public interface InterpreterVisitor {

    AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree);

    void visitValueAssignation(ValueAssignationSyntaxBranch branch);

    VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch);

    void visitSumSub(SumSubOperationSyntaxBranch branch);

    void visitMultDiv(MultDivOperationSyntaxBranch branch);

    void visitNumberType(NumberTypeSyntaxLeaf leaf);

    void visitStringType(StringTypeSyntaxLeaf leaf);

    void visitVariable(VariableSyntaxLeaf leaf);

    void visitLiteral(LiteralSyntaxLeaf leaf);

    void visitEmpty(EmptySyntaxLeaf leaf);
}
