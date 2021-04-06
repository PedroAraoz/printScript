package edu.austral.ingsis;

import edu.austral.ingsis.visitor.Visitor;

public class SumSubOperationSyntaxBranch extends AbstractSyntaxBranch {
  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) {
    return tree.addSumSubOperationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) {
    return branch.addSumSubOperationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) {
    if (right.isEmpty()) {
      right = branch;
    } else if (left.isEmpty()) {
      left = branch;
    } else {
      branch.addSumSubOperationSyntaxTree(this);
      return branch;
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
    if (right.isEmpty()) {
      right = branch;
    } else if (left.isEmpty()) {
      left = branch;
    } else {
      branch.addLiteralSyntaxLeaf((LiteralSyntaxLeaf) left);
      this.left = branch;
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) {
    return null;
  }

  @Override
  public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) {
    if (right.isEmpty()) {
      right = leaf;
    } else if (left.isEmpty()) {
      left = leaf;
    } else {
      // Agregar por si left o right son MULTDIVs
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) {
    if (right.isEmpty()) {
      right = leaf;
    } else if (left.isEmpty()) {
      left = leaf;
    } else {
      // Agregar por si left o right son MULTDIVs
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
    return this;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitSumSub(this);
    left.accept(visitor);
    right.accept(visitor);
  }
}
