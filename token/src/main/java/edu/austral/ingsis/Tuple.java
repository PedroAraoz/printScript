package edu.austral.ingsis;

public class Tuple {
  private final Token token;
  private final String optional;

  public Tuple(Token token, String optional) {
    this.token = token;
    this.optional = optional;
  }

  public Token getToken() {
    return token;
  }

  public String getString() {
    return optional.replaceAll(
        "^[\"']+|[\"']+$", ""); // This is in order to remove the quotes from the value
  }
}
