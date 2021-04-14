package edu.austral.ingsis;

public class Tuple {
  private final TokenIdentifier tokenIdentifier;
  private final String optional;

  public Tuple(TokenIdentifier tokenIdentifier, String optional) {
    this.tokenIdentifier = tokenIdentifier;
    this.optional = optional;
  }

  public TokenIdentifier getToken() {
    return tokenIdentifier;
  }

  public String getString() {
    return optional.replaceAll(
        "^[\"']+|[\"']+$", ""); // This is in order to remove the quotes from the value
  }
}
