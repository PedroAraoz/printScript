package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class MultDivOperationSyntaxBranch extends AbstractSyntaxBranch {
  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
    return tree.addMultDivOperationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) throws CompilationTimeException {
    return branch.addMultDivOperationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.token.getLine() + " column " + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) throws CompilationTimeException {
    return branch.addMultDivOperationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) {
    if (right.isEmpty()) {
      right = branch;
    } else if (left.isEmpty()) {
      left = branch;
    } else {
      branch.addMultDivOperationSyntaxTree(this);
      return branch;
    }
    return this;
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
    if (right.isEmpty()) {
      right = leaf;
    } else if (left.isEmpty()) {
      left = leaf;
    } else {
      left.addVariableSyntaxLeaf(leaf);
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) throws CompilationTimeException {
    if (right.isEmpty()) {
      right = leaf;
    } else if (left.isEmpty()) {
      left = leaf;
    } else {
      left.addLiteralSyntaxLeaf(leaf);
    }
    return this;
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
  public void accept(Visitor visitor) {
    left.accept(visitor);
    right.accept(visitor);
    visitor.visitMultDiv(this);
  }
}
