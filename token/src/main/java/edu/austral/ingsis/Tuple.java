package edu.austral.ingsis;

import java.util.Optional;

public class Tuple {
  private final Token token;
  private final Optional<String> optional;
  
  public Tuple(Token token) {
    this.token = token;
    optional = Optional.empty();
  }
  
  public Tuple(Token token, Optional<String> optional) {
    this.token = token;
    this.optional = optional;
  }
  
  public Token getToken() {
    return token;
  }
  
  public Optional<String> getOptional() {
    return optional;
  }
}
