package edu.austral.ingsis;

import java.util.*;
import java.util.stream.Collectors;

public class TokenFactory {
  private final Stack<Character> stack = new Stack<>();
  private final List<TokenWrapper> list = new ArrayList<>();
  
  public Optional<Token> put(String string) {
    final List<String> list = Arrays.asList(string.split("(?!^)"));
    list.forEach(this::analyzeCharacter);
    return null;
  }
  
  private void analyzeCharacter(String c) {
    final Optional<TokenWrapper> first = list.stream().filter(t -> t.getRegex().matcher(c).matches()).findFirst();
    if (first.isPresent()) {
//      return first.get().getType();
    }
  }
}
