package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.TypeAssignationSyntaxBranch;

public class TypeAssignationCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new TypeAssignationSyntaxBranch();
  }
}
