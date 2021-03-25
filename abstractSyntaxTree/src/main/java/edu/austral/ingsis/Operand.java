package edu.austral.ingsis;

public interface Operand extends AbstractSyntaxTree {
  Literal calculate();
}
