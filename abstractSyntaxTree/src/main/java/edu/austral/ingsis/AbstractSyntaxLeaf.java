package edu.austral.ingsis;

public abstract class AbstractSyntaxLeaf implements AbstractSyntaxTree {

  protected TokenWrapper tokenWrapper;

  public void setTokenWrapper(TokenWrapper tokenWrapper) {
    this.tokenWrapper = tokenWrapper;
  }

  public TokenWrapper getTokenWrapper() {
    return tokenWrapper;
  }

  public boolean isEmpty() {
    return false;
  }
}
