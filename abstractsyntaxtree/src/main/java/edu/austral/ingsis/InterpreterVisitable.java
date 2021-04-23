package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public interface InterpreterVisitable {
  AbstractSyntaxTree accept2(InterpreterVisitor visitor) throws CompilationTimeException;
}
