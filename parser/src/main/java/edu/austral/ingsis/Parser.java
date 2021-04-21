package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.List;

public interface Parser {

  AbstractSyntaxTree analyseSintactically(List<Token> tokenList) throws CompilationTimeException;

  List<AbstractSyntaxTree> analyseSintactically(Lexer lexer) throws CompilationTimeException;
}
