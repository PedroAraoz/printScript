package edu.austral.ingsis;

public interface InterpreterVisitable {
  AbstractSyntaxTree accept2(InterpreterVisitor visitor);
}
