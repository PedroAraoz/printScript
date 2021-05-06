package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ParserSegmenterTests {

  /*
   * TODO Ale
   * Parser segmenter should start empty
   * parser segmenter of empty lexer should be emtpy
   * parser segmenter of one statement should return it
   * parser segmenter of many statements should return them
   * incomplete statement should throw error
   * VERSION 1.1:
   * parser segmenter of If should return if () {}
   * parser segmenter of IF Else should return if () {} else {}
   * parser segmenter of if with one statement should return statement inside
   * if with many statements should return them inside
   * else with statements should return them inside
   * when there are no more nexts should return hasNext false
   * when there are more statements should return hasNext true
   * incomplete if should throw error
   * incomplete if else should throw error
   */

  @Test
  public void shouldStartEmpty() throws CompilationTimeException {
    final ParserSegmenter parserSegmenter = new ParserSegmenter(new LexerImpl());
    assert parserSegmenter.getNext().isEmpty();
  }

  @Test
  public void ofEmptyLexerShouldBeEmpty() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();
    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    assert parserSegmenter.getNext().isEmpty();
  }

  @Test
  public void oneStatementLexerShouldReturnOneStatement() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();

    final List<String> statement = new ArrayList<>();
    statement.add("x = 3;");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens = parserSegmenter.getNext();

    assert !tokens.isEmpty();
    System.out.println("ASD");
  }

  @Test
  public void twoStatementsLexerShouldReturnTwoStatements() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();

    final List<String> statement = new ArrayList<>();
    statement.add("x = 3;");
    statement.add("y = 5;");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens1 = parserSegmenter.getNext();
    List<Token> tokens2 = parserSegmenter.getNext();

    assert !tokens1.isEmpty();
    assert !tokens2.isEmpty();
    System.out.println("ASD");
  }

  @Test(expected = CompilationTimeException.class)
  public void malformedStatementsLexerShouldThrowError() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();

    final List<String> statement = new ArrayList<>();
    statement.add("x = 3");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens1 = parserSegmenter.getNext();
  }

  @Test
  public void onlySemicolonShouldBeReturned() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();

    final List<String> statement = new ArrayList<>();
    statement.add(";");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens1 = parserSegmenter.getNext();
    assert tokens1.get(0).getTokenIdentifier().equals(TokenIdentifier.SEMICOLON_TOKEN);
  }
}
