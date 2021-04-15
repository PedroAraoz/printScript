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

  void visitPrintLn(PrintLnSyntaxLeaf leaf);

  void visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf);

  void visitRightParenthesis(RightParenthesisSyntaxLeaf leaf);

  void visitBooleanType(BooleanTypeSyntaxLeaf leaf);

  void visitGreaterThan(GreaterThanOperationSyntaxBranch branch);

  void visitLesserThan(LesserThanOperationSyntaxBranch branch);

  void visitLesserEqualThan(LesserEqualThanOperationSyntaxBranch branch);

  void visitGreaterEqualThan(GreaterEqualThanOperationSyntaxBranch branch);

  void visitLeftBracket(LeftBracketSyntaxLeaf leaf);

  void visitRightBracket(RightBracketSyntaxLeaf leaf);

  void visitIfElse(IfElseOperationSyntaxBranch branch);
}
