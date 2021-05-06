package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.LeftParenthesisSyntaxLeaf;

public class LeftParenthesisCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new LeftParenthesisSyntaxLeaf();
    }
}
