package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

  @Test
  public void emptyIfStatementShouldBeReturnedCorrectly() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");

    final List<String> statement = new ArrayList<>();
    statement.add("if (x) {}");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens1 = parserSegmenter.getNext();
    assert tokens1.get(0).getTokenIdentifier().equals(TokenIdentifier.IF_TOKEN);
    assert tokens1.get(1).getTokenIdentifier().equals(TokenIdentifier.LEFT_PARENTHESIS_TOKEN);
    assert tokens1.get(2).getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN);
    assert tokens1.get(3).getTokenIdentifier().equals(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN);
    assert tokens1.get(4).getTokenIdentifier().equals(TokenIdentifier.LEFT_BRACKET_TOKEN);
    assert tokens1.get(5).getTokenIdentifier().equals(TokenIdentifier.RIGHT_BRACKET_TOKEN);
  }

  @Test
  public void ifWithOneStatementShouldBeReturnedCorrectly() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();

    final List<String> statement = new ArrayList<>();
    statement.add("if (x) {x = 3;}");

    lexer.setVersion("1.1");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens1 = parserSegmenter.getNext();
    assert tokens1.get(0).getTokenIdentifier().equals(TokenIdentifier.IF_TOKEN);
    assert tokens1.get(1).getTokenIdentifier().equals(TokenIdentifier.LEFT_PARENTHESIS_TOKEN);
    assert tokens1.get(2).getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN);
    assert tokens1.get(3).getTokenIdentifier().equals(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN);
    assert tokens1.get(4).getTokenIdentifier().equals(TokenIdentifier.LEFT_BRACKET_TOKEN);
    assert tokens1.get(5).getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN);
    assert tokens1.get(6).getTokenIdentifier().equals(TokenIdentifier.VALUE_ASSIGNATION_TOKEN);
    assert tokens1.get(7).getTokenIdentifier().equals(TokenIdentifier.NUMBER_LITERAL_TOKEN);
    assert tokens1.get(8).getTokenIdentifier().equals(TokenIdentifier.SEMICOLON_TOKEN);
    assert tokens1.get(9).getTokenIdentifier().equals(TokenIdentifier.RIGHT_BRACKET_TOKEN);
  }

  @Test
  public void ifWithTwoStatementsShouldBeReturnedCorrectly() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();

    final List<String> statement = new ArrayList<>();
    statement.add("if (x) {x = 3; y = 4;}");

    lexer.setVersion("1.1");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens1 = parserSegmenter.getNext();
    assert tokens1.get(0).getTokenIdentifier().equals(TokenIdentifier.IF_TOKEN);
    assert tokens1.get(1).getTokenIdentifier().equals(TokenIdentifier.LEFT_PARENTHESIS_TOKEN);
    assert tokens1.get(2).getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN);
    assert tokens1.get(3).getTokenIdentifier().equals(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN);
    assert tokens1.get(4).getTokenIdentifier().equals(TokenIdentifier.LEFT_BRACKET_TOKEN);
    assert tokens1.get(5).getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN);
    assert tokens1.get(6).getTokenIdentifier().equals(TokenIdentifier.VALUE_ASSIGNATION_TOKEN);
    assert tokens1.get(7).getTokenIdentifier().equals(TokenIdentifier.NUMBER_LITERAL_TOKEN);
    assert tokens1.get(8).getTokenIdentifier().equals(TokenIdentifier.SEMICOLON_TOKEN);
    assert tokens1.get(9).getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN);
    assert tokens1.get(10).getTokenIdentifier().equals(TokenIdentifier.VALUE_ASSIGNATION_TOKEN);
    assert tokens1.get(11).getTokenIdentifier().equals(TokenIdentifier.NUMBER_LITERAL_TOKEN);
    assert tokens1.get(12).getTokenIdentifier().equals(TokenIdentifier.SEMICOLON_TOKEN);
    assert tokens1.get(13).getTokenIdentifier().equals(TokenIdentifier.RIGHT_BRACKET_TOKEN);
  }

  @Test
  public void emptyIfElseShouldBeReturnedCorrectly() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();

    final List<String> statement = new ArrayList<>();
    statement.add("if (x) {} else {}");

    lexer.setVersion("1.1");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens1 = parserSegmenter.getNext();
    assert tokens1.get(0).getTokenIdentifier().equals(TokenIdentifier.IF_TOKEN);
    assert tokens1.get(1).getTokenIdentifier().equals(TokenIdentifier.LEFT_PARENTHESIS_TOKEN);
    assert tokens1.get(2).getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN);
    assert tokens1.get(3).getTokenIdentifier().equals(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN);
    assert tokens1.get(4).getTokenIdentifier().equals(TokenIdentifier.LEFT_BRACKET_TOKEN);
    assert tokens1.get(5).getTokenIdentifier().equals(TokenIdentifier.RIGHT_BRACKET_TOKEN);
    assert tokens1.get(6).getTokenIdentifier().equals(TokenIdentifier.ELSE_TOKEN);
    assert tokens1.get(7).getTokenIdentifier().equals(TokenIdentifier.LEFT_BRACKET_TOKEN);
    assert tokens1.get(8).getTokenIdentifier().equals(TokenIdentifier.RIGHT_BRACKET_TOKEN);
  }

  @Test
  public void IfElseWithStatementsShouldBeReturnedCorrectly() throws CompilationTimeException {
    final Lexer lexer = new LexerImpl();

    final List<String> statement = new ArrayList<>();
    statement.add("if (x) {x = 3;} else {x = 3;}");

    lexer.setVersion("1.1");

    lexer.analyseLexically(statement);

    final ParserSegmenter parserSegmenter = new ParserSegmenter(lexer);

    List<Token> tokens1 = parserSegmenter.getNext();
    Assert.assertEquals(tokens1.get(0).getTokenIdentifier(), (TokenIdentifier.IF_TOKEN));
    Assert.assertEquals(tokens1.get(1).getTokenIdentifier(), (TokenIdentifier.LEFT_PARENTHESIS_TOKEN));
    Assert.assertEquals(tokens1.get(2).getTokenIdentifier(), (TokenIdentifier.VARIABLE_TOKEN));
    Assert.assertEquals(tokens1.get(3).getTokenIdentifier(), (TokenIdentifier.RIGHT_PARENTHESIS_TOKEN));
    Assert.assertEquals(tokens1.get(4).getTokenIdentifier(), (TokenIdentifier.LEFT_BRACKET_TOKEN));
    Assert.assertEquals(tokens1.get(5).getTokenIdentifier(), (TokenIdentifier.VARIABLE_TOKEN));
    Assert.assertEquals(tokens1.get(6).getTokenIdentifier(), (TokenIdentifier.VALUE_ASSIGNATION_TOKEN));
    Assert.assertEquals(tokens1.get(7).getTokenIdentifier(), (TokenIdentifier.NUMBER_LITERAL_TOKEN));
    Assert.assertEquals(tokens1.get(8).getTokenIdentifier(), (TokenIdentifier.SEMICOLON_TOKEN));
    Assert.assertEquals(tokens1.get(9).getTokenIdentifier(), (TokenIdentifier.RIGHT_BRACKET_TOKEN));
    Assert.assertEquals(tokens1.get(10).getTokenIdentifier(), (TokenIdentifier.ELSE_TOKEN));
    Assert.assertEquals(tokens1.get(11).getTokenIdentifier(), (TokenIdentifier.LEFT_BRACKET_TOKEN));
    Assert.assertEquals(tokens1.get(12).getTokenIdentifier(), (TokenIdentifier.VARIABLE_TOKEN));
    Assert.assertEquals(tokens1.get(13).getTokenIdentifier(), (TokenIdentifier.VALUE_ASSIGNATION_TOKEN));
    Assert.assertEquals(tokens1.get(14).getTokenIdentifier(), (TokenIdentifier.NUMBER_LITERAL_TOKEN));
    Assert.assertEquals(tokens1.get(15).getTokenIdentifier(), (TokenIdentifier.SEMICOLON_TOKEN));
    Assert.assertEquals(tokens1.get(16).getTokenIdentifier(), (TokenIdentifier.RIGHT_BRACKET_TOKEN));
  }
}
