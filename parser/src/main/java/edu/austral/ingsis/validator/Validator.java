package edu.austral.ingsis.validator;

import edu.austral.ingsis.AbstractSyntaxTree;
import edu.austral.ingsis.exception.CompilationTimeException;

public interface Validator {
    void validate(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException;
}
