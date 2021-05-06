package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class ASTSerializer implements Visitor {

  private StringBuilder bobTheBuilder = new StringBuilder();

  public String getString() {
    return bobTheBuilder.toString();
  }

  @Override
  public void visit(AbstractSyntaxTree abstractSyntaxTree) {
    abstractSyntaxTree.accept(this);
  }

  @Override
  public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {
    bobTheBuilder
        .append("|")
        .append(branch.getToken().getName())
        .append(":")
        .append(branch.getToken().getValue());
  }

  @Override
  public void visitTypeAssingation(TypeAssignationSyntaxBranch branch) {
    bobTheBuilder
        .append("|")
        .append(branch.getToken().getName())
        .append(":")
        .append(branch.getToken().getValue());
  }

  @Override
  public void visitSumSub(SumSubOperationSyntaxBranch branch) {
    bobTheBuilder
        .append("|")
        .append(branch.getToken().getName())
        .append(":")
        .append(branch.getToken().getValue());
  }

  @Override
  public void visitMultDiv(MultDivOperationSyntaxBranch branch) {
    bobTheBuilder
        .append("|")
        .append(branch.getToken().getName())
        .append(":")
        .append(branch.getToken().getValue());
  }

  @Override
  public void visitNumberType(NumberTypeSyntaxLeaf leaf) {
    bobTheBuilder
        .append("|")
        .append(leaf.getToken().getName())
        .append(":")
        .append(leaf.getToken().getValue());
  }

  @Override
  public void visitStringType(StringTypeSyntaxLeaf leaf) {
    bobTheBuilder
        .append("|")
        .append(leaf.getToken().getName())
        .append(":")
        .append(leaf.getToken().getValue());
  }

  @Override
  public void visitVariable(VariableSyntaxLeaf leaf) {
    bobTheBuilder
        .append("|")
        .append(leaf.getToken().getName())
        .append(":")
        .append(leaf.getToken().getValue());
  }

  @Override
  public void visitLiteral(LiteralSyntaxLeaf leaf) {
    bobTheBuilder
        .append("|")
        .append(leaf.getToken().getName())
        .append(":")
        .append(leaf.getToken().getValue());
  }

  @Override
  public void visitEmpty(EmptySyntaxLeaf leaf) {
    bobTheBuilder
        .append("|")
        .append(leaf.getToken().getName())
        .append(":")
        .append(leaf.getToken().getValue());
  }

  @Override
  public void visitPrintLn(PrintLnSyntaxLeaf leaf) {
    bobTheBuilder
        .append("|")
        .append(leaf.getToken().getName())
        .append(":")
        .append(leaf.getToken().getValue());
    bobTheBuilder
        .append("|")
        .append(leaf.getExpression().getToken().getName())
        .append(":")
        .append(leaf.getExpression().getToken().getValue());
  }

  @Override
  public void visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf) {
    bobTheBuilder
        .append("|")
        .append(leaf.getToken().getName())
        .append(":")
        .append(leaf.getToken().getValue());
    bobTheBuilder
        .append("|")
        .append(leaf.getResultingExpression().getToken().getName())
        .append(":")
        .append(leaf.getResultingExpression().getToken().getValue());
  }

  @Override
  public void visitRightParenthesis(RightParenthesisSyntaxLeaf leaf) {
    bobTheBuilder
        .append("|")
        .append(leaf.getToken().getName())
        .append(":")
        .append(leaf.getToken().getValue());
  }
}
