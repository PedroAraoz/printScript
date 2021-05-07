package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;
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
  }

  @Test
  public void testtest() throws FileNotFoundException, CompilationTimeException {
    test("testtest");
  }

  public void test(String directory) throws FileNotFoundException, CompilationTimeException {
    String testDirectory = "src/test/resources/parser-tests/" + directory + "/";
    List<String> statements = readLines(testDirectory + "input.txt");
    List<String> outputs = readLines(testDirectory + "output.txt");

    Lexer lexer = new LexerImpl();
    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    for (int i = 0, treesSize = trees.size(); i < treesSize; i++) {
      ASTSerializer astSerializer = new ASTSerializer();
      astSerializer.visit(trees.get(i));
      //            System.out.println(astSerializer.getString());
      Assert.assertEquals(outputs.get(i), astSerializer.getString());
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
