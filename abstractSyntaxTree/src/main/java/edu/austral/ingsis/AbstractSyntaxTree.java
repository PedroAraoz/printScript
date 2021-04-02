package edu.austral.ingsis;

public interface AbstractSyntaxTree extends Visitable {

  void setTokenWrapper(TokenWrapper tokenWrapper);

  AbstractSyntaxTree add(AbstractSyntaxTree tree);

  AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch);

  AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch);

  AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch);

  AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch);

  AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf);

  AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf);

  AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf);

  AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf);

  AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf);

  boolean isEmpty();
}
