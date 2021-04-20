package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.LesserThanOperationSyntaxBranch;

public class LesserCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new LesserThanOperationSyntaxBranch();
  }
}
