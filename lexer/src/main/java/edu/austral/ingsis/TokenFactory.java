package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TokenFactory {

  private final List<Token> tokenList = new ArrayList<>();// TODO que traiga esta lista de algun lado
  private StringBuilder stringBuilder = new StringBuilder();

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
