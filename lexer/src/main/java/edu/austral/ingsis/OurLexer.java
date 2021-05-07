package edu.austral.ingsis;

import java.util.List;
import java.util.Optional;

public interface OurLexer {
  void analyseLexically(List<String> string);

  Optional<OurToken> getNextToken();

  boolean hasNext();

  List<OurToken> getAll();

  void setVersion(String version);

  Optional<OurToken> peek();
}
