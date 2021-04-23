package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.BooleanTypeSyntaxLeaf;

public class BooleanTypeCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new BooleanTypeSyntaxLeaf();
  }
}
