package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.util.List;

public interface Parser {

  AbstractSyntaxTree analyseSintactically(List<OurToken> tokenList) throws CompilationTimeException;

  List<AbstractSyntaxTree> analyseSintactically(OurLexer lexer) throws CompilationTimeException;
}
