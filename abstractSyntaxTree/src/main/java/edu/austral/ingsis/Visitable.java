package edu.austral.ingsis;

import edu.austral.ingsis.visitor.Visitor;

public interface Visitable {
  void accept(Visitor visitor);
}
