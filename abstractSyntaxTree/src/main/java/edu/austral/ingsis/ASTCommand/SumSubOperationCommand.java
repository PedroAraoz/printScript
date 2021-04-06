package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.SumSubOperationSyntaxBranch;

public class SumSubOperationCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new SumSubOperationSyntaxBranch();
  }
}
