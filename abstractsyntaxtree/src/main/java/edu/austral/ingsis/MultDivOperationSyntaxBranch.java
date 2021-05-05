package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public class MultDivOperationSyntaxBranch extends AbstractSyntaxBranch {
  @Override
  public AbstractSyntaxTree add(AbstractSyntaxTree tree) throws CompilationTimeException {
    return tree.addMultDivOperationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch)
      throws CompilationTimeException {
    return branch.addMultDivOperationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch)
      throws CompilationTimeException {
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
  public AbstractSyntaxTree addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addVariableSyntaxLeaf(VariableSyntaxLeaf leaf)
      throws CompilationTimeException {
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
  public AbstractSyntaxTree addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf)
      throws CompilationTimeException {
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
  public AbstractSyntaxTree addPrintLnSyntaxLeaf(PrintLnSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLeftParenthesisSyntaxLeaf(LeftParenthesisSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addRightParenthesisSyntaxLeaf(RightParenthesisSyntaxLeaf leaf)
      throws CompilationTimeException {
    return leaf.addMultDivOperationSyntaxTree(this);
  }

  @Override
  public AbstractSyntaxTree addBooleanTypeSyntaxLeaf(BooleanTypeSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addGreaterThanOperationSyntaxBranch(
      GreaterThanOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLesserThanOperationSyntaxBranch(
      LesserThanOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addLesserEqualThanOperationSyntaxBranch(
      LesserEqualThanOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addGreaterEqualThanOperationSyntaxBranch(
      GreaterEqualThanOperationSyntaxBranch branch) throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addIfOperationSyntaxBranch(IfOperationSyntaxBranch branch)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public AbstractSyntaxTree addConstSyntaxLeaf(ConstSyntaxLeaf leaf)
      throws CompilationTimeException {
    throw new CompilationTimeException(
        "Parser Exception when building AST in line "
            + this.token.getLine()
            + " column "
            + this.token.getStartPos());
  }

  @Override
  public void accept(Visitor visitor) throws CompilationTimeException {
    left.accept(visitor);
    right.accept(visitor);
    visitor.visitMultDiv(this);
  }

  @Override
  public AbstractSyntaxTree accept2(InterpreterVisitor visitor) throws CompilationTimeException {
    return visitor.visitMultDiv(this);
  }
}
