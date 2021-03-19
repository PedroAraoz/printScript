package edu.austral.ingsis;

import java.util.regex.Pattern;

public class TokenThing {
  private final TokenEnum tokenEnum;
  private final Pattern regex;
  
  public TokenThing(TokenEnum tokenEnum, Pattern regex) {
    this.tokenEnum = tokenEnum;
    this.regex = regex;
  }
  
  public TokenEnum getType() {
    return tokenEnum;
  }
  
  public Pattern getRegex() {
    return regex;
  }
}
