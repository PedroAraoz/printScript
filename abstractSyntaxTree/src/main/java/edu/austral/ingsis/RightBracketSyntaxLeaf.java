package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class RightBracketSyntaxLeaf extends AbstractSyntaxLeaf {
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
  public AbstractSyntaxTree addIfElseOperationSyntaxBranch(IfElseOperationSyntaxBranch branch) {
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
