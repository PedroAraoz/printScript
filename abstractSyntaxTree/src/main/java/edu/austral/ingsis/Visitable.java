package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public interface Visitable {
  void accept(Visitor visitor) throws CompilationTimeException;
}
