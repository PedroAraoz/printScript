package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.EmptySyntaxLeaf;

public class EmptyCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new EmptySyntaxLeaf();
    }
}
