package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.ConstSyntaxLeaf;

public class ConstCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new ConstSyntaxLeaf();
  }
}
