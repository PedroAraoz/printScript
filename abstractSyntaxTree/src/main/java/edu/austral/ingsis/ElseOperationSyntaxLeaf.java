package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class ElseOperationSyntaxLeaf implements AbstractSyntaxTree {
  @Override
  public void setToken(Token token) {

  }

  @Override
  public Token getToken() {
    return null;
  }

  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addPrintLnSyntaxLeaf(PrintLnSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addBooleanTypeSyntaxLeaf(BooleanTypeSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addGreaterThanOperationSyntaxBranch(GreaterThanOperationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLesserThanOperationSyntaxBranch(LesserThanOperationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLesserEqualThanOperationSyntaxBranch(LesserEqualThanOperationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addGreaterEqualThanOperationSyntaxBranch(GreaterEqualThanOperationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addLeftBracketSyntaxLeaf(LeftBracketSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addRightBracketSyntaxLeaf(RightBracketSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree addIfOperationSyntaxBranch(IfOperationSyntaxBranch branch) throws CompilationTimeException {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public AbstractSyntaxTree addConstSyntaxLeaf(ConstSyntaxLeaf leaf) throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree accept2(InterpreterVisitor visitor) throws CompilationTimeException {
    return null;
  }

  @Override
  public void accept(Visitor visitor) {

  }
}
