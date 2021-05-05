package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class EmptyValidatorVisitor implements Visitor {

  private boolean foundEmpty = false;

  @Override
  public void visit(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException {
    abstractSyntaxTree.accept(this);
  }

  @Override
  public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {}

  @Override
  public void visitTypeAssingation(TypeAssignationSyntaxBranch branch) {}

  @Override
  public void visitSumSub(SumSubOperationSyntaxBranch branch) {}

  @Override
  public void visitMultDiv(MultDivOperationSyntaxBranch branch) {}

  @Override
  public void visitNumberType(NumberTypeSyntaxLeaf leaf) {}

  @Override
  public void visitStringType(StringTypeSyntaxLeaf leaf) {}

  @Override
  public void visitVariable(VariableSyntaxLeaf leaf) {}

  @Override
  public void visitLiteral(LiteralSyntaxLeaf leaf) {}

  @Override
  public void visitEmpty(EmptySyntaxLeaf leaf) {
    foundEmpty = true;
  }

  @Override
  public void visitPrintLn(PrintLnSyntaxLeaf leaf) {}

  @Override
  public void visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf) {}

  @Override
  public void visitRightParenthesis(RightParenthesisSyntaxLeaf leaf) {}

  @Override
  public void visitBooleanType(BooleanTypeSyntaxLeaf leaf) {}

  @Override
  public void visitGreaterThan(GreaterThanOperationSyntaxBranch branch) {}

  @Override
  public void visitLesserThan(LesserThanOperationSyntaxBranch branch) {}

  @Override
  public void visitLesserEqualThan(LesserEqualThanOperationSyntaxBranch branch) {}

  @Override
  public void visitGreaterEqualThan(GreaterEqualThanOperationSyntaxBranch branch) {}

  @Override
  public void visitIf(IfOperationSyntaxBranch branch) {}

  @Override
  public void visitConst(ConstSyntaxLeaf constSyntaxLeaf) {}

  public boolean foundEmpty() {
    return foundEmpty;
  }
}
