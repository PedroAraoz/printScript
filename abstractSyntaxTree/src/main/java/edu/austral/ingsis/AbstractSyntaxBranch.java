package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public abstract class AbstractSyntaxBranch implements AbstractSyntaxTree {

  protected AbstractSyntaxTree left = new EmptySyntaxLeaf();
  protected TokenWrapper tokenWrapper;
  protected AbstractSyntaxTree right = new EmptySyntaxLeaf();

  public String getValue() {
    return tokenWrapper.getValue();
  }
  
  public void setTokenWrapper(TokenWrapper tokenWrapper) {
    this.tokenWrapper = tokenWrapper;
  }

  public AbstractSyntaxTree getLeft() {
    return left;
  }

  @Override
  public TokenWrapper getTokenWrapper() {
    return tokenWrapper;
  }

  public AbstractSyntaxTree getRight() {
    return right;
  }

  public boolean isEmpty() {
    return false;
  }

  protected void addRight(AbstractSyntaxTree tree) throws CompilationTimeException {
    if (this.right.isEmpty()) {
      this.right = tree;
    } else {
      right = right.add(tree);
    }
  }

  protected void addLeft(AbstractSyntaxTree tree) throws CompilationTimeException {
    if (this.left.isEmpty()) {
      this.left = tree;
    } else {
      this.left = left.add(tree);
    }
  }
}
