package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.List;

public class ParserImpl implements Parser {

  public ParserImpl() {
    this.astFactory = new ASTFactory();
  }

  private final ASTFactory astFactory;

  @Override
  public AbstractSyntaxTree analyseSintactically(List<Token> tokenList) throws CompilationTimeException {
    return astFactory.build(tokenList);
  }
}
