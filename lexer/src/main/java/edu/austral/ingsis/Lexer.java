package edu.austral.ingsis;

import java.util.List;

public interface Lexer {
  List<Token> analyseLexically(CodeLine line);

  void setVersion(String version);
}
