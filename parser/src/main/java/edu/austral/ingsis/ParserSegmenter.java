package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.util.ArrayList;
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
    // In the case lexer is empty
    if (!lexer.hasNext()) {
      hasNext = false;
      return;
    }
    segmentStatement();
  }

  private void segmentStatement() throws CompilationTimeException {
    List<Token> statement = new ArrayList<>();
    while (lexer.hasNext()) {
      Token one = lexer.getNextToken().get();
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
  } // todo el get(0) esta mal.
}
