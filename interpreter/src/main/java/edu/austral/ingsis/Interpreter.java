package edu.austral.ingsis;

public interface Interpreter {
  void interpret(AbstractSyntaxTree ast, Printer printer);
}
