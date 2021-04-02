package edu.austral.ingsis;

public class TypeAssignationSyntaxBranch extends AbstractSyntaxBranch {
  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) {
    return tree.addTypeAsignationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) {
    if (right.isEmpty()) {
      right = leaf;
    } else {
      // EXplode
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) {
    if (right.isEmpty()) {
      right = leaf;
    } else {
      // EXplode
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) {
    if (left.isEmpty()) {
      left = leaf;
    } else {
      // EXplode
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
    return null;
  }

  @Override
  public void accept(Visitor visitor) {}
}
