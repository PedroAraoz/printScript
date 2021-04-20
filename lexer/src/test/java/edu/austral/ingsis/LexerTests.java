package edu.austral.ingsis;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexerTests {
  // todo saque el checkeo de posiciones en todos los tests. tenemos que hacer 1 de eso.
  @Test
  public void DeclarationAsignationOperationTest() {
    final List<String> codeLineList = new ArrayList<>();
    codeLineList.add("let x: number = 2 + 3");
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 3, "let"));
    expected.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 3, 4, "x"));
    expected.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 4, 5, ":"));
    expected.add(new Token(TokenIdentifier.NUMBER_TYPE_TOKEN, 0, 5, 11, "number"));
    expected.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 11, 12, "="));
    expected.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 12, 13, "2"));
    expected.add(new Token(TokenIdentifier.SUM_OPERATION_TOKEN, 0, 13, 14, "+"));
    expected.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 14, 15, "3"));
    LexerImpl lexer = new LexerImpl();
    lexer.analyseLexically(codeLineList);
    List<Token> tokens = lexer.getAll();
    
    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
      Assert.assertEquals(e.toString(), a.toString());
      Assert.assertEquals(e.getLine(), a.getLine());
      Assert.assertEquals(e.getValue(), a.getValue());
    }
  }
  
  @Test
  public void NumberLiteralTest() {
    List<String> codeLineList = new ArrayList<>();
    codeLineList.add("let x: number = 2222;");
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    expected.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    expected.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    expected.add(new Token(TokenIdentifier.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    expected.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    expected.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "2222"));
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
  public void StringDoubleQuoteLiteralTest() {
    List<String> codeLineList = new ArrayList<>();
    codeLineList.add("let x: string = \"hola\";");
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
  public void printLnTest() {
    List<String> codeLineList = new ArrayList<>();
    codeLineList.add("printLn('hola');");
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.PRINTLN_TOKEN, 0, 0, 0, "printLn"));
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
  public void asdasdasdasd() {
    LexerImpl lexer = new LexerImpl();
    lexer.analyseLexically(Collections.singletonList("1+2;"));
    final List<Token> all = lexer.getAll();
    System.out.println("asd");
  }
}
