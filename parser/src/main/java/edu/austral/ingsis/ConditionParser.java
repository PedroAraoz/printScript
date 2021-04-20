package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConditionParser {

  final private ASTFactory astFactory;

  public ConditionParser(ASTFactory astFactory) {
    this.astFactory = astFactory;
  }

  public AbstractSyntaxTree analyseSintactically(List<Token> tokenList) throws CompilationTimeException {
    return parseCondition(tokenList);
  }

  private AbstractSyntaxTree parseCondition(List<Token> tokenList) throws CompilationTimeException {
    return astFactory.build(tokenList);
  }

//  List<Token> header = new ArrayList<>();
//  List<Token> body = new ArrayList<>();
//  Iterator<Token> iterator = tokenList.iterator();
//    while (iterator.hasNext()) {
//    Token token = iterator.next();
//    header.add(token);
//    if (token.getTokenIdentifier().equals(TokenIdentifier.LEFT_BRACKET_TOKEN)) {
//      break;
//    }
//  }
//    while (iterator.hasNext()) {
//    Token token = iterator.next();
//    if (token.getTokenIdentifier().equals(TokenIdentifier.RIGHT_BRACKET_TOKEN)) {
//      break;
//    }
//    body.add(token);
//  }
//    return null;
}
