package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public interface AbstractSyntaxTree extends Visitable, InterpreterVisitable {

  void setToken(OurToken token);

  OurToken getToken();

  AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException;

  AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch)
      throws CompilationTimeException;

  AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch)
      throws CompilationTimeException;

  AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch)
      throws CompilationTimeException;

  AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch)
      throws CompilationTimeException;

  AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf)
      throws CompilationTimeException;

  AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf)
      throws CompilationTimeException;

  AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) throws CompilationTimeException;

  AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) throws CompilationTimeException;

  AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf);

  AbstractSyntaxTree addPrintLnSyntaxLeaf(PrintLnSyntaxLeaf leaf) throws CompilationTimeException;

  AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf)
      throws CompilationTimeException;

  AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf)
      throws CompilationTimeException;

  AbstractSyntaxTree addBooleanTypeSyntaxLeaf(BooleanTypeSyntaxLeaf leaf)
      throws CompilationTimeException;

  AbstractSyntaxTree addGreaterThanOperationSyntaxBranch(GreaterThanOperationSyntaxBranch branch)
      throws CompilationTimeException;

  AbstractSyntaxTree addLesserThanOperationSyntaxBranch(LesserThanOperationSyntaxBranch branch)
      throws CompilationTimeException;

  AbstractSyntaxTree addLesserEqualThanOperationSyntaxBranch(
      LesserEqualThanOperationSyntaxBranch branch) throws CompilationTimeException;

  AbstractSyntaxTree addGreaterEqualThanOperationSyntaxBranch(
      GreaterEqualThanOperationSyntaxBranch branch) throws CompilationTimeException;

  AbstractSyntaxTree addIfOperationSyntaxBranch(IfOperationSyntaxBranch branch)
      throws CompilationTimeException;

  boolean isEmpty();

  AbstractSyntaxTree addConstSyntaxLeaf(ConstSyntaxLeaf leaf) throws CompilationTimeException;
}
