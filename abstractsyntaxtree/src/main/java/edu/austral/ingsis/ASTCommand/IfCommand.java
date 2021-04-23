package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.IfOperationSyntaxBranch;

public class IfCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new IfOperationSyntaxBranch();
  }
}
