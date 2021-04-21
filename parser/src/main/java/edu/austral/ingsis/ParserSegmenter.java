package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParserSegmenter {

  private Lexer lexer;
  private List<Token> next;
  private boolean hasNext = true;

  public ParserSegmenter(Lexer lexer) throws CompilationTimeException {
    this.lexer = lexer;
    internalGetNext();
  }

  public boolean hasNext() {
    return hasNext;
  }

  public List<Token> getNext() throws CompilationTimeException {
    if (hasNext) {

      List<Token> toReturn = new ArrayList<>(next);

      internalGetNext();

      return toReturn;

    } else {
      return new ArrayList<>();
    }
  }

  private void internalGetNext() throws CompilationTimeException {
    List<Token> statement = new ArrayList<>();

    // In the case lexer is empty
    if (!lexer.hasNext()) {
      hasNext = false;
      return;
    }

    if (lexer.peek().get().getTokenIdentifier().equals(TokenIdentifier.IF_TOKEN)) {
      segmentIf(statement);
    } else {
      segmentStatement(statement);
    }
  }

  private void segmentIf(List<Token> statement) throws CompilationTimeException {
    // Ya detectamos el if asi que lo agregamos directamente
    Token ifToken = lexer.getNextToken().get();
    statement.add(ifToken);

    // Consumimos la primera parte del If que siempre debe ser igual
    consume(statement, ifToken, TokenIdentifier.LEFT_PARENTHESIS_TOKEN, "If statement does not open condition parenthesis in line ", "Dangling If statement in line ");
    consume(statement, ifToken, TokenIdentifier.VARIABLE_TOKEN, "If statement does not contain variable in condition in line ", "Condition not found in If statement in line ");
    consume(statement, ifToken, TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, "If statement does not close condition parenthesis in line ", "Condition not closed in If statement in line ");
    consume(statement, ifToken, TokenIdentifier.LEFT_BRACKET_TOKEN, "If statement does not open brackets in line ", "If statement does not open brackets in line ");

    // Consumimos los statements del If
    

    // Consumimos el ultimo bracket
    consume(statement, ifToken, TokenIdentifier.RIGHT_BRACKET_TOKEN, "If statement does not close brackets in line ", "If statement does not close brackets in line ");
  }

  private void consume(List<Token> statement, Token ifToken, TokenIdentifier identifier, String unexpectedTokenErrorMessage, String noNextTokenErrorMessage) throws CompilationTimeException {
    if (lexer.hasNext()) {
      Token nextToken = lexer.getNextToken().get();
      if (!nextToken.getTokenIdentifier().equals(identifier)) {
        throw new CompilationTimeException(unexpectedTokenErrorMessage + nextToken.getLine() + " in column " + nextToken.getStartPos());
      } else {
        statement.add(nextToken);
      }
    } else {
      throw new CompilationTimeException(noNextTokenErrorMessage + ifToken.getLine() + " in column " + ifToken.getStartPos());
    }
  }

  private void segmentStatement(List<Token> statement) throws CompilationTimeException {
    while (lexer.hasNext()) {
      Token one = lexer.getNextToken().get();
      statement.add(one);
      if (one.getTokenIdentifier().equals(TokenIdentifier.SEMICOLON_TOKEN)) {
        next = statement;
        return;
      }
    }
    throw new CompilationTimeException("Missing semicolon in line " + statement.get(0).getLine() + " in column " + statement.get(0).getStartPos());
  }
}
