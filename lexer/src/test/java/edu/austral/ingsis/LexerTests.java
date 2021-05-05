package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class LexerTests {

  @Test
  public void DeclarationAsignationOperationTest() throws FileNotFoundException {
    test("test01");
  }

  @Test
  public void NumberLiteralTest() throws FileNotFoundException {
    test("test02");
  }

  @Test
  public void StringDoubleQuoteLiteralTest() throws FileNotFoundException {
    test("test03");
  }

  @Test
  public void StringSimpleQuoteLiteralTest() {
    List<String> codeLineList = new ArrayList<>();
    codeLineList.add("let x: string = 'hola';");
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    expected.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    expected.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    expected.add(new Token(TokenIdentifier.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
    expected.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    expected.add(new Token(TokenIdentifier.STRING_LITERAL_TOKEN, 0, 0, 0, "hola"));
    expected.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    lexer.analyseLexically(codeLineList);
    final List<Token> tokens = lexer.getAll();
    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
      Assert.assertEquals(e.toString(), a.toString());
      Assert.assertEquals(e.getLine(), a.getLine());
      Assert.assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void parenthesisTest() {
    List<String> codeLineList = new ArrayList<>();
    codeLineList.add("( x: string = 'hola' );");
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    expected.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    expected.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    expected.add(new Token(TokenIdentifier.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
    expected.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    expected.add(new Token(TokenIdentifier.STRING_LITERAL_TOKEN, 0, 0, 0, "hola"));
    expected.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    expected.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    lexer.analyseLexically(codeLineList);
    final List<Token> tokens = lexer.getAll();
    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
      Assert.assertEquals(e.toString(), a.toString());
      Assert.assertEquals(e.getLine(), a.getLine());
      Assert.assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void printlnTest() {
    List<String> codeLineList = new ArrayList<>();
    codeLineList.add("println('hola');");
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.PRINTLN_TOKEN, 0, 0, 0, "println"));
    expected.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    expected.add(new Token(TokenIdentifier.STRING_LITERAL_TOKEN, 0, 0, 0, "hola"));
    expected.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    expected.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    lexer.analyseLexically(codeLineList);
    final List<Token> tokens = lexer.getAll();
    System.out.println("asd");
    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
      Assert.assertEquals(e.toString(), a.toString());
      Assert.assertEquals(e.getLine(), a.getLine());
      Assert.assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void ifInOnePointZero() {
    LexerImpl lexer = new LexerImpl();
    lexer.analyseLexically(Collections.singletonList("if"));
    final Token token = lexer.getNextToken().get();
    Assert.assertEquals(TokenName.VARIABLE, token.getName());
  }

  @Test
  public void ifInOnePointOne() {
    LexerImpl lexer = new LexerImpl();
    lexer.setVersion("1.1");
    lexer.analyseLexically(Collections.singletonList("if"));
    final Token token = lexer.getNextToken().get();
    Assert.assertEquals(TokenName.IF, token.getName());
  }

  @Test
  public void testSpaceInString() {
    LexerImpl lexer = new LexerImpl();
    lexer.analyseLexically(Collections.singletonList("'hola amigo'"));
    final List<Token> all = lexer.getAll();
    Assert.assertEquals(1, all.size());
    Assert.assertEquals(TokenName.STRING_LITERAL, all.get(0).getName());
  }

  public void test(String directory) throws FileNotFoundException {
    String testDirectory = "src/test/resources/lexer-tests/" + directory + "/";
    List<String> statements = readLines(testDirectory + "input.txt");
    List<String> values = readLines(testDirectory + "tokenValues.txt");
    List<String> ti = readLines(testDirectory + "tokenIdentifiers.txt");
    List<String> lines = readLines(testDirectory + "tokenLines.txt");

    Lexer lexer = new LexerImpl();

    lexer.analyseLexically(statements);
    final List<Token> all = lexer.getAll();

    for (int i = 0; i < values.size(); i++) {
      Assert.assertEquals(values.get(i), all.get(i).getValue());
      Assert.assertEquals(ti.get(i), all.get(i).getTokenIdentifier().toString());
      Assert.assertEquals(lines.get(i), Integer.toString(all.get(i).getLine()));
    }
  }

  private List<String> readLines(String file) throws FileNotFoundException {
    Scanner s = new Scanner(new java.io.File(file));
    ArrayList<String> list = new ArrayList<>();
    while (s.hasNextLine()) {
      list.add(s.nextLine());
    }
    s.close();
    return list;
  }
}
