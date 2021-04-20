package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class StringTypeSyntaxLeaf extends AbstractSyntaxLeaf {
  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
    return tree.addStringTypeSyntaxLeaf(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) throws CompilationTimeException {
    return branch.addStringTypeSyntaxLeaf(this);
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
  public AbstractSyntaxTree addPrintLnSyntaxLeaf(PrintLnSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addBooleanTypeSyntaxLeaf(BooleanTypeSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addGreaterThanOperationSyntaxBranch(GreaterThanOperationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLesserThanOperationSyntaxBranch(LesserThanOperationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLesserEqualThanOperationSyntaxBranch(LesserEqualThanOperationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addGreaterEqualThanOperationSyntaxBranch(GreaterEqualThanOperationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLeftBracketSyntaxLeaf(LeftBracketSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addRightBracketSyntaxLeaf(RightBracketSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addIfOperationSyntaxBranch(IfOperationSyntaxBranch branch) {
    return null;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitStringType(this);
  }
  
  @Override
  public AbstractSyntaxTree accept2(InterpreterVisitor visitor) {
    return visitor.visitStringType(this);
  }
}
