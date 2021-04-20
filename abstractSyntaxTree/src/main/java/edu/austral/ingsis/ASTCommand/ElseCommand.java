package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.ElseOperationSyntaxLeaf;

public class ElseCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new ElseOperationSyntaxLeaf();
  }
}
