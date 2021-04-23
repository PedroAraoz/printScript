package edu.austral.ingsis;

public abstract class AbstractSyntaxLeaf implements AbstractSyntaxTree {

  protected Token token;

  public String getValue() {
    return token.getValue();
  }

  @Override
  public void setToken(Token token) {
    this.token = token;
  }

  @Override
  public Token getToken() {
    return token;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
