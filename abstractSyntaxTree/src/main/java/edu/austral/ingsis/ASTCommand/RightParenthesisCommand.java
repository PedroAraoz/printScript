package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.RightParenthesisSyntaxLeaf;

public class RightParenthesisCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new RightParenthesisSyntaxLeaf();
    }
}
