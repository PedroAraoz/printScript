package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class TypeAssignationSyntaxBranch extends AbstractSyntaxBranch {
  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
    return tree.addTypeAsignationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.tokenWrapper.getLine() + " column " + this.tokenWrapper.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.tokenWrapper.getLine() + " column " + this.tokenWrapper.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.tokenWrapper.getLine() + " column " + this.tokenWrapper.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.tokenWrapper.getLine() + " column " + this.tokenWrapper.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf) throws CompilationTimeException {
    if (right.isEmpty()) {
      right = leaf;
    } else {
      throw new CompilationTimeException("Parser Exception when building AST in line " + this.tokenWrapper.getLine() + " column " + this.tokenWrapper.getStartPos());
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf) throws CompilationTimeException {
    if (right.isEmpty()) {
      right = leaf;
    } else {
      throw new CompilationTimeException("Parser Exception when building AST in line " + this.tokenWrapper.getLine() + " column " + this.tokenWrapper.getStartPos());
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf) throws CompilationTimeException {
    if (left.isEmpty()) {
      left = leaf;
    } else {
      throw new CompilationTimeException("Parser Exception when building AST in line " + this.tokenWrapper.getLine() + " column " + this.tokenWrapper.getStartPos());
    }
    return this;
  }

  @Override
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf) throws CompilationTimeException {
    throw new CompilationTimeException("Parser Exception when building AST in line " + this.tokenWrapper.getLine() + " column " + this.tokenWrapper.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addEmptySyntaxLeaf(EmptySyntaxLeaf leaf) {
    return this;
  }

  @Override
  public void accept(Visitor visitor) {
    left.accept(visitor);
    right.accept(visitor);
    visitor.visitTypeAssingation(this);
  }
}
