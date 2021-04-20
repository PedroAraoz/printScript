package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.LeftBracketSyntaxLeaf;

public class LeftBracketCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new LeftBracketSyntaxLeaf();
  }
}
