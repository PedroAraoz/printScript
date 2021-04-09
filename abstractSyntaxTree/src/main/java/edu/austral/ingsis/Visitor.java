package edu.austral.ingsis;

public interface Visitor {

  void visit(AbstractSyntaxTree abstractSyntaxTree);

  void visitValueAssignation(ValueAssignationSyntaxBranch branch);

  void visitTypeAssingation(TypeAssignationSyntaxBranch branch);

  void visitSumSub(SumSubOperationSyntaxBranch branch);

  void visitMultDiv(MultDivOperationSyntaxBranch branch);

  void visitNumberType(NumberTypeSyntaxLeaf leaf);

  void visitStringType(StringTypeSyntaxLeaf leaf);

  void visitVariable(VariableSyntaxLeaf leaf);

  void visitLiteral(LiteralSyntaxLeaf leaf);

  void visitEmpty(EmptySyntaxLeaf leaf);
}
