package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.GreaterThanOperationSyntaxBranch;

public class GreaterCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new GreaterThanOperationSyntaxBranch();
  }
}
