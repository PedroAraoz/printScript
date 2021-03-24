package edu.austral.ingsis;

import java.util.List;
import java.util.Optional;

public class TokenFactory {

  private final List<Token> tokenList;
  private StringBuilder stringBuilder = new StringBuilder();

  public TokenFactory() {
    this.tokenList = Token.getAllTokens();
  }

  public Optional<Token> put(String c) {
    stringBuilder.append(c);
    Optional<Token> tokenOptional = tokenList.stream().filter(t -> t.getRegex().matcher(stringBuilder.toString()).matches()).findFirst();
    if (tokenOptional.isPresent()) {
      stringBuilder = new StringBuilder();
      return tokenOptional;
    }
    return tokenOptional;
  }
}
