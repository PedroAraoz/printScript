package edu.austral.ingsis;

import java.util.Optional;

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
    return optional;
  }
}
