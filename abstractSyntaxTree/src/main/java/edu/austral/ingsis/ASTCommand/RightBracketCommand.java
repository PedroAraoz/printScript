package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.RightBracketSyntaxLeaf;

public class RightBracketCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new RightBracketSyntaxLeaf();
  }
}
