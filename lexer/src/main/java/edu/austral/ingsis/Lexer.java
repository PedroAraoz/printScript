package edu.austral.ingsis;

import java.util.List;
import java.util.Optional;

public interface Lexer {
  void analyseLexically(List<String> string);
  Optional<Token> getNextToken();
  boolean hasNext();
  List<Token> getAll();
  void setVersion(String version);
  Optional<Token> peek();
}
