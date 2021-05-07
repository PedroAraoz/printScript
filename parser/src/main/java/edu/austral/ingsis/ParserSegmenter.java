package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserSegmenter {

  private OurLexer lexer;
  private List<OurToken> next;
  private boolean hasNext = true;

  public ParserSegmenter(OurLexer lexer) throws CompilationTimeException {
    this.lexer = lexer;
    internalGetNext();
  }

  public boolean hasNext() {
    return hasNext;
  }

  public List<OurToken> getNext() throws CompilationTimeException {
    if (hasNext) {

      List<OurToken> toReturn = new ArrayList<>(next);

      internalGetNext();

      return toReturn;

    } else {
      return new ArrayList<>();
    }
  }

  private void internalGetNext() throws CompilationTimeException {
    List<OurToken> statement = new ArrayList<>();

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

  private void segmentIf(List<OurToken> statement) throws CompilationTimeException {
    // Ya detectamos el if asi que lo agregamos directamente
    OurToken ifToken = lexer.getNextToken().get();
    statement.add(ifToken);

    // Consumimos la primera parte del If que siempre debe ser igual
    consume(
        statement,
        ifToken,
        TokenIdentifier.LEFT_PARENTHESIS_TOKEN,
        "If statement does not open condition parenthesis in line ",
        "Dangling If statement in line ");
    consume(
        statement,
        ifToken,
        TokenIdentifier.VARIABLE_TOKEN,
        "If statement does not contain variable in condition in line ",
        "Condition not found in If statement in line ");
    consume(
        statement,
        ifToken,
        TokenIdentifier.RIGHT_PARENTHESIS_TOKEN,
        "If statement does not close condition parenthesis in line ",
        "Condition not closed in If statement in line ");
    consume(
        statement,
        ifToken,
        TokenIdentifier.LEFT_BRACKET_TOKEN,
        "If statement does not open brackets in line ",
        "If statement does not open brackets in line ");

    // Consumimos el ultimo bracket
    consumeUntil(
        statement,
        ifToken,
        TokenIdentifier.RIGHT_BRACKET_TOKEN,
        "If statement does not close brackets in line ");

    Optional<OurToken> t = lexer.peek();
    if (t.isPresent() && t.get().getTokenIdentifier().equals(TokenIdentifier.ELSE_TOKEN)) {
      consumeUntil(
          statement,
          t.get(),
          TokenIdentifier.LEFT_BRACKET_TOKEN,
          "Else statement does not open brackets in line ");
      consumeUntil(
          statement,
          t.get(),
          TokenIdentifier.RIGHT_BRACKET_TOKEN,
          "Else statement does not close brackets in line ");
    }
    next = statement;
  }

  private void consumeUntil(
      List<OurToken> statement,
      OurToken ifToken,
      TokenIdentifier identifier,
      String noNextTokenErrorMessage)
      throws CompilationTimeException {
    while (lexer.hasNext()) {
      OurToken t = lexer.getNextToken().get();
      statement.add(t);
      if (t.getTokenIdentifier().equals(identifier)) return;
    }
    throw new CompilationTimeException(
        noNextTokenErrorMessage + ifToken.getLine() + " in column " + ifToken.getStartPos());
  }

  private void consume(
      List<OurToken> statement,
      OurToken token,
      TokenIdentifier identifier,
      String unexpectedTokenErrorMessage,
      String noNextTokenErrorMessage)
      throws CompilationTimeException {
    if (lexer.hasNext()) {
      OurToken nextToken = lexer.getNextToken().get();
      if (!nextToken.getTokenIdentifier().equals(identifier)) {
        throw new CompilationTimeException(
            unexpectedTokenErrorMessage
                + nextToken.getLine()
                + " in column "
                + nextToken.getStartPos());
      } else {
        statement.add(nextToken);
      }
    } else {
      throw new CompilationTimeException(
          noNextTokenErrorMessage + token.getLine() + " in column " + token.getStartPos());
    }
  }

  private void segmentStatement(List<OurToken> statement) throws CompilationTimeException {
    while (lexer.hasNext()) {
      OurToken one = lexer.getNextToken().get();
      statement.add(one);
      if (one.getTokenIdentifier().equals(TokenIdentifier.SEMICOLON_TOKEN)) {
        next = statement;
        return;
      }
    }
    throw new CompilationTimeException(
        "Missing semicolon in line "
            + statement.get(0).getLine()
            + " in column "
            + statement.get(0).getStartPos());
  }
}
