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
    if (tokenList.get(0).getTokenIdentifier().equals(TokenIdentifier.IF_TOKEN)) {
      ConditionParser conditionParser = new ConditionParser(astFactory);
      return conditionParser.analyseSintactically(tokenList);
    } else {
      return astFactory.build(tokenList);
    }
  }
}
