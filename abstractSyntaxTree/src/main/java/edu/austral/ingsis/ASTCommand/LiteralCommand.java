package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.LiteralSyntaxLeaf;

public class LiteralCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new LiteralSyntaxLeaf();
    }
}
