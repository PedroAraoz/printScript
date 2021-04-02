package edu.austral.ingsis;

import java.util.List;

public class ParserImpl implements Parser {

  private final ASTFactory astFactory = new ASTFactory();
  private final ASTVerifier astVerifier = new ASTVerifier();

  @Override
  public AbstractSyntaxTree analyseSintactically(List<TokenWrapper> tokenWrapperList) {
    return astFactory.build(tokenWrapperList);
  }

  @Override
  public boolean analyseSemantically(AbstractSyntaxTree ast) {
    return false;
  }
}
