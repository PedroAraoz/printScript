package edu.austral.ingsis;

public abstract class AbstractSyntaxLeaf implements AbstractSyntaxTree {

  protected TokenWrapper tokenWrapper;
  
  public String getValue() {
    return tokenWrapper.getValue();
  }
  
  public void setTokenWrapper(TokenWrapper tokenWrapper) {
    this.tokenWrapper = tokenWrapper;
  }

  @Override
  public TokenWrapper getTokenWrapper() {
    return tokenWrapper;
  }

  public boolean isEmpty() {
    return false;
  }
}
