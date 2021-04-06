package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.StringTypeSyntaxLeaf;

public class StringTypeCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new StringTypeSyntaxLeaf();
    }
}
