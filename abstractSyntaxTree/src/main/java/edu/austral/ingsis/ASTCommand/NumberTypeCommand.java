package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.NumberTypeSyntaxLeaf;

public class NumberTypeCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new NumberTypeSyntaxLeaf();
    }
}
