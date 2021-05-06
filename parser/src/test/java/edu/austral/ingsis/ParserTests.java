package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;

public class ParserTests {

  @Test
  public void testDeclaAsignMult() throws CompilationTimeException, FileNotFoundException {
    test("test01");
  }

  @Test
  public void TwoOperationsSum() throws CompilationTimeException, FileNotFoundException {
    test("test02");
  }

  @Test
  public void testDeclaString() throws CompilationTimeException, FileNotFoundException {
    test("test03");
  }

  @Test
  public void testDeclaAsignString() throws CompilationTimeException, FileNotFoundException {
    test("test04");
  }

  @Test
  public void asigVarMult() throws CompilationTimeException, FileNotFoundException {
    test("test05");
  }

  @Test
  public void SumMult() throws CompilationTimeException, FileNotFoundException {
    test("test06");
  }

  @Test(expected = CompilationTimeException.class)
  public void emptyWithSum() throws FileNotFoundException, CompilationTimeException {
    test("test07");
  }

  @Test(expected = CompilationTimeException.class)
  public void emptyWithMult() throws FileNotFoundException, CompilationTimeException {
    test("test08");
  }

  @Test(expected = CompilationTimeException.class)
  public void emptyWithValueAsign() throws FileNotFoundException, CompilationTimeException {
    test("test09");
  }

  @Test(expected = CompilationTimeException.class)
  public void emptyWithTypeAsign() throws FileNotFoundException, CompilationTimeException {
    test("test10");
  }

  @Test
  public void multipleOperationsSum() throws CompilationTimeException, FileNotFoundException {
    test("test11");
  }

  @Test
  public void multipleOperationsMult() throws CompilationTimeException, FileNotFoundException {
    test("test12");
  }

  @Test
  public void sumWithVariables() throws CompilationTimeException, FileNotFoundException {
    test("test13");
  }

  @Test
  public void multWithVariables() throws CompilationTimeException, FileNotFoundException {
    test("test14");
  }

  @Test
  public void multSumMix() throws CompilationTimeException, FileNotFoundException {
    test("test15");
  }

  @Test
  public void testParenthesis() throws CompilationTimeException, FileNotFoundException {
    test("test16");
  }

  @Test
  public void testPrintLn() throws CompilationTimeException, FileNotFoundException {
    test("test17");
    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.PRINTLN_TOKEN, 0, 0, 0, "PrintLn"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testBooleanType() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.BOOLEAN_TYPE_TOKEN, 0, 0, 0, "boolean"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.BOOLEAN_LITERAL_TOKEN, 0, 0, 0, "true"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testConst() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.CONST_TOKEN, 0, 0, 0, "const"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.BOOLEAN_TYPE_TOKEN, 0, 0, 0, "boolean"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.BOOLEAN_LITERAL_TOKEN, 0, 0, 0, "true"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testGreaterThan() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.BOOLEAN_TYPE_TOKEN, 0, 0, 0, "boolean"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.GREATER_TOKEN, 0, 0, 0, ">"));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "2"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testLesserThan() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.BOOLEAN_TYPE_TOKEN, 0, 0, 0, "boolean"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.LESSER_TOKEN, 0, 0, 0, "<"));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "2"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testLesserEqualsThan() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.BOOLEAN_TYPE_TOKEN, 0, 0, 0, "boolean"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.LESSER_EQUALS_TOKEN, 0, 0, 0, "<="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "2"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testGreaterEqualsThan() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.BOOLEAN_TYPE_TOKEN, 0, 0, 0, "boolean"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.GREATER_EQUALS_TOKEN, 0, 0, 0, ">="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "2"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testEmptyIf() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testIfWithOneSentence() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testIfWithTwoSentences() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testEmtpyIfElse() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    list.add(new Token(TokenIdentifier.ELSE_TOKEN, 0, 0, 0, "else"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testIfElseWithOneSentenceEach() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    list.add(new Token(TokenIdentifier.ELSE_TOKEN, 0, 0, 0, "else"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testIfElseWithTwoSentencesEach() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    list.add(new Token(TokenIdentifier.ELSE_TOKEN, 0, 0, 0, "else"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new Token(TokenIdentifier.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    list.add(new Token(TokenIdentifier.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test(expected = CompilationTimeException.class)
  public void testIfWithWrongSentence() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test(expected = CompilationTimeException.class)
  public void testIfElseWithWrongSentenceInBoth() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    list.add(new Token(TokenIdentifier.ELSE_TOKEN, 0, 0, 0, "else"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test(expected = CompilationTimeException.class)
  public void testIfElseWithWrongSentenceInElse() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<Token> list = new ArrayList<>();
    list.add(new Token(TokenIdentifier.IF_TOKEN, 0, 0, 0, "if"));
    list.add(new Token(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, 0, 0, 0, "("));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, 0, 0, 0, ")"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    list.add(new Token(TokenIdentifier.ELSE_TOKEN, 0, 0, 0, "else"));
    list.add(new Token(TokenIdentifier.LEFT_BRACKET_TOKEN, 0, 0, 0, "{"));
    list.add(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new Token(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new Token(TokenIdentifier.RIGHT_BRACKET_TOKEN, 0, 0, 0, "}"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testtest() throws FileNotFoundException, CompilationTimeException {
    test("testtest");
  }

  public void test(String directory) throws FileNotFoundException, CompilationTimeException {
    test(directory, "1.0");
  }

  public void test(String directory, String version)
      throws FileNotFoundException, CompilationTimeException {
    String testDirectory = "src/test/resources/parser-tests/" + directory + "/";
    List<String> statements = readLines(testDirectory + "input.txt");
    List<String> outputs = readLines(testDirectory + "output.txt");

    Lexer lexer = new LexerImpl();
    lexer.setVersion(version);
    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    for (int i = 0, treesSize = trees.size(); i < treesSize; i++) {
      ASTSerializer astSerializer = new ASTSerializer();
      astSerializer.visit(trees.get(i));
      System.out.println(astSerializer.getString());
      //      Assert.assertEquals(outputs.get(i), astSerializer.getString());
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
