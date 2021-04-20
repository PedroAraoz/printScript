package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.GreaterEqualThanOperationSyntaxBranch;

public class GreaterEqualsCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new GreaterEqualThanOperationSyntaxBranch();
  }
}
