package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.MultDivOperationSyntaxBranch;

public class MultDivOperationCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new MultDivOperationSyntaxBranch();
    }
}
