package edu.austral.ingsis.validator;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.exception.CompilationTimeException;
import edu.austral.ingsis.visitor.OperationMatchVisitor;

public class OperationMatchValidator implements edu.austral.ingsis.validator.Validator {

    /*
    * This validator checks that if an operation containing strings is found, that operation only contains '+' signs
     */

    @Override
    public void validate(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException {

        OperationMatchVisitor visitor = new OperationMatchVisitor();
        abstractSyntaxTree.accept(visitor);

        if (!visitor.match()) {
            throw new CompilationTimeException("Cannot apply operation to type string");
        }
    }
}
