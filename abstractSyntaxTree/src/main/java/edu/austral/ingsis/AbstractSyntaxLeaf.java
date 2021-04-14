package edu.austral.ingsis;

public abstract class AbstractSyntaxLeaf implements AbstractSyntaxTree {

  protected Token token;
  
  public String getValue() {
    return token.getValue();
  }
  
  public void setTokenWrapper(Token token) {
    this.token = token;
  }

  @Override
  public Token getTokenWrapper() {
    return token;
  }

  public boolean isEmpty() {
    return false;
  }
}
