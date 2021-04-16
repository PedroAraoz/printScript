package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class BooleanTypeSyntaxLeaf extends AbstractSyntaxLeaf {
  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
    return tree.addBooleanTypeSyntaxLeaf(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) throws CompilationTimeException {
    return branch.addBooleanTypeSyntaxLeaf(this);
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
    return this;
  }

  @Override
  public AbstractSyntaxTree addPrintLnSyntaxLeaf(PrintLnSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addBooleanTypeSyntaxLeaf(BooleanTypeSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addGreaterThanOperationSyntaxBranch(GreaterThanOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLesserThanOperationSyntaxBranch(LesserThanOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLesserEqualThanOperationSyntaxBranch(LesserEqualThanOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addGreaterEqualThanOperationSyntaxBranch(GreaterEqualThanOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLeftBracketSyntaxLeaf(LeftBracketSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addRightBracketSyntaxLeaf(RightBracketSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addIfOperationSyntaxBranch(IfOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitBooleanType(this);
  }

  @Override
  public AbstractSyntaxTree accept2(InterpreterVisitor visitor) {
    return visitor.visitBooleanType(this);
  }
}
