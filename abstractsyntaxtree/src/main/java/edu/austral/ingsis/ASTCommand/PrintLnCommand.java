package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.PrintLnSyntaxLeaf;

public class PrintLnCommand implements ASTCommand {
  @Override
  public AbstractSyntaxTree build() {
    return new PrintLnSyntaxLeaf();
  }
}
