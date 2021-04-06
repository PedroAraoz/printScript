package edu.austral.ingsis.ASTCommand;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.ValueAssignationSyntaxBranch;

public class ValueAssignationCommand implements ASTCommand {
    @Override
    public AbstractSyntaxTree build() {
        return new ValueAssignationSyntaxBranch();
    }
}
