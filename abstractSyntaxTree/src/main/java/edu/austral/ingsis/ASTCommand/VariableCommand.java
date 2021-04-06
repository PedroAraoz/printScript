package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.VariableSyntaxLeaf;

public class VariableCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new VariableSyntaxLeaf();
    }
}
