/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.austral.ingsis;

import java.util.List;

public class ParserImpl implements Parser {

  private final ASTFactory astFactory = new ASTFactory();

  @Override
  public AbstractSyntaxTree analyseSintactically(List<TokenWrapper> tokenWrapperList) {
    return null;
  }

  @Override
  public boolean analyseSemantically(AbstractSyntaxTree ast) {
    return false;
  }
}
