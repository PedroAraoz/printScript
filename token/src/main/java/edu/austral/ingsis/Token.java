package edu.austral.ingsis;

import java.util.Optional;

public interface Token {
  int getStartPos();
  int getEndPos();
  int getLine();
  String toString();
  TokenEnum getType();
  Optional<String> getValue();
}
