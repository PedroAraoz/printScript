package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public abstract class AbstractSyntaxBranch implements AbstractSyntaxTree {

  protected AbstractSyntaxTree left = new EmptySyntaxLeaf();
  protected Token token;
  protected AbstractSyntaxTree right = new EmptySyntaxLeaf();

  public String getValue() {
    return token.getValue();
  }
  
  public void setTokenWrapper(Token token) {
    this.token = token;
  }

  public AbstractSyntaxTree getLeft() {
    return left;
  }

  @Override
  public Token getTokenWrapper() {
    return token;
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
