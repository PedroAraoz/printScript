package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.List;

public interface Parser {

  AbstractSyntaxTree analyseSintactically(List<TokenWrapper> tokenWrapperList) throws CompilationTimeException;

  void analyseSemantically(AbstractSyntaxTree ast) throws CompilationTimeException;
}
