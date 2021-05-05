package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class EmptySyntaxLeaf extends AbstractSyntaxLeaf {
  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) {
    return tree.addEmptySyntaxLeaf(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addPrintLnSyntaxLeaf(PrintLnSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addBooleanTypeSyntaxLeaf(BooleanTypeSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public AbstractSyntaxTree addGreaterThanOperationSyntaxBranch(
      GreaterThanOperationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public AbstractSyntaxTree addLesserThanOperationSyntaxBranch(
      LesserThanOperationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public AbstractSyntaxTree addLesserEqualThanOperationSyntaxBranch(
      LesserEqualThanOperationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public AbstractSyntaxTree addGreaterEqualThanOperationSyntaxBranch(
      GreaterEqualThanOperationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public AbstractSyntaxTree addIfOperationSyntaxBranch(IfOperationSyntaxBranch branch) {
    return branch;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitEmpty(this);
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public AbstractSyntaxTree addConstSyntaxLeaf(ConstSyntaxLeaf leaf)
      throws CompilationTimeException {
    return null;
  }

  @Override
  public AbstractSyntaxTree accept2(InterpreterVisitor visitor) {
    return visitor.visitEmpty(this);
  }
}
