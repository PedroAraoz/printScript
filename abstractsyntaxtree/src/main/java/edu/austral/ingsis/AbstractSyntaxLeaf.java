package edu.austral.ingsis;

public abstract class AbstractSyntaxLeaf implements AbstractSyntaxTree {

  protected OurToken token;

  public String getValue() {
    return token.getValue();
  }

  @Override
  public void setToken(OurToken token) {
    this.token = token;
  }

  @Override
  public OurToken getToken() {
    return token;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
