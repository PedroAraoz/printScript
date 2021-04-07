package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.List;

public interface Parser {

  AbstractSyntaxTree analyseSintactically(List<TokenWrapper> tokenWrapperList) throws CompilationTimeException;

  boolean analyseSemantically(AbstractSyntaxTree ast);
}
