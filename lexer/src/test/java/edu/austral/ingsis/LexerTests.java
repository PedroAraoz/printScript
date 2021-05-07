package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
  public void StringSimpleQuoteLiteralTest() throws FileNotFoundException {
    test("test04");
  }

  @Test
  public void parenthesisTest() throws FileNotFoundException {
    test("test05");
  }

  @Test
  public void printlnTest() throws FileNotFoundException {
    test("test06");
  }

  @Test
  public void ifInOnePointZero() throws FileNotFoundException {
    test("test07");
  }

  @Test
  public void ifInOnePointOne() throws FileNotFoundException {
    test("test08", "1.1");
  }

  @Test
  public void testSpaceInString() throws FileNotFoundException {
    test("test09");
  }

  @Test
  public void testSpaceBeforeCharacters_ShouldNotBeRemoved() throws FileNotFoundException {
    test("test10");
  }

  @Test
  public void testMultipleLines() throws FileNotFoundException {
    test("test11");
  }

  @Test
  public void testStringAdditionWithSpace() throws FileNotFoundException {
    test("test12");
  }

  @Test
  public void testPriorityOneTokenWordInStringWithSpace() throws FileNotFoundException {
    test("test13");
  }

  @Test
  public void testPriorityOneTokenWordInStringWithoutSpace() throws FileNotFoundException {
    test("test14");
  }

  public void test(String directory) throws FileNotFoundException {
    test(directory, "1.0");
  }

  public void test(String directory, String version) throws FileNotFoundException {
    String testDirectory = "src/test/resources/lexer-tests/" + directory + "/";
    List<String> statements = readLines(testDirectory + "input.txt");
    List<String> values = readLines(testDirectory + "tokenValues.txt");
    List<String> ti = readLines(testDirectory + "tokenIdentifiers.txt");
    List<String> lines = readLines(testDirectory + "tokenLines.txt");

    Lexer lexer = new LexerImpl();
    lexer.setVersion(version);
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
