package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.LesserEqualThanOperationSyntaxBranch;

public class LesserEqualsCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new LesserEqualThanOperationSyntaxBranch();
  }
}
