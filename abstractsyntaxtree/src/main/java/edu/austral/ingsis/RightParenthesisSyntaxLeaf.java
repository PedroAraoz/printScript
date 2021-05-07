package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class RightParenthesisSyntaxLeaf extends AbstractSyntaxLeaf {

  private AbstractSyntaxTree resultingExpression = new EmptySyntaxLeaf();

  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
    return tree.addRightParenthesisSyntaxLeaf(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch)
      throws CompilationTimeException {
    resultingExpression = resultingExpression.add(branch);
    return this;
  }

  @Override
  public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch)
      throws CompilationTimeException {
    resultingExpression = resultingExpression.add(branch);
    return this;
  }

  @Override
  public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf)
      throws CompilationTimeException {
    resultingExpression = resultingExpression.add(leaf);
    return this;
  }

  @Override
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf)
      throws CompilationTimeException {
    resultingExpression = resultingExpression.add(leaf);
    return this;
  }

  @Override
  public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
    return this;
  }

  @Override
  public AbstractSyntaxTree addPrintLnSyntaxLeaf(PrintLnSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf) {
    return leaf.addRightParenthesisSyntaxLeaf(this);
  }

  @Override
  public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitRightParenthesis(this);
  }

  public AbstractSyntaxTree getResultingExpression() {
    return resultingExpression;
  }

  @Override
  public AbstractSyntaxTree accept2(InterpreterVisitor visitor) {
    return visitor.visitRightParenthesis(this);
  }
}
