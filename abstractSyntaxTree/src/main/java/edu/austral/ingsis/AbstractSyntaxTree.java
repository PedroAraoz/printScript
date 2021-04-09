package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public interface AbstractSyntaxTree extends Visitable {

  void setTokenWrapper(TokenWrapper tokenWrapper);

  TokenWrapper getTokenWrapper();

  AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException;

  AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) throws CompilationTimeException;

  AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) throws CompilationTimeException;

  AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) throws CompilationTimeException;

  AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) throws CompilationTimeException;

  AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) throws CompilationTimeException;

  AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) throws CompilationTimeException;

  AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) throws CompilationTimeException;

  AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) throws CompilationTimeException;

  AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf);

  boolean isEmpty();
}
