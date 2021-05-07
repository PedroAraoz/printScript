package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class InterpreterTests {

  @Test
  public void interpretBooleanDeclarationStatement() throws CompilationTimeException {
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());

    AbstractSyntaxTree abstractSyntaxTree = new VariableSyntaxLeaf();
    abstractSyntaxTree.setToken(new OurToken(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    AbstractSyntaxTree second = new TypeAssignationSyntaxBranch();
    second.setToken(new OurToken(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    abstractSyntaxTree = abstractSyntaxTree.add(second);
    second = new BooleanTypeSyntaxLeaf();
    second.setToken(new OurToken(TokenIdentifier.BOOLEAN_TYPE_TOKEN, 0, 0, 0, "boolean"));
    abstractSyntaxTree = abstractSyntaxTree.add(second);

    interpreter.visit(abstractSyntaxTree);
  }

  @Test
  public void interpreterTestsFromFileOutputFalse()
      throws FileNotFoundException, CompilationTimeException {
    List<String> directories = new ArrayList<>();
    directories.add("test01");
    directories.add("test02");

    for (String directory : directories) {
      test(directory, false);
    }
  }

  @Test
  public void interpreterTestsFromFileOutputTrue()
      throws FileNotFoundException, CompilationTimeException {
    List<String> directories = new ArrayList<>();
    directories.add("test03");
    directories.add("test04");

    for (String directory : directories) {
      test(directory, true);
    }
  }

  @Test
  public void testIfandElse() throws FileNotFoundException, CompilationTimeException {
    test("test05", "1.1", false);
  }

  @Test(expected = CompilationTimeException.class)
  public void interpretWrongGreaterThanAssignation()
      throws CompilationTimeException, FileNotFoundException {
    test("test06", "1.1", false);
  }

  @Test(expected = CompilationTimeException.class)
  public void wrongTypeStringNumberConcat() throws CompilationTimeException, FileNotFoundException {
    test("test07", "1.1", false);
  }

  @Test
  public void stringConcat() throws CompilationTimeException, FileNotFoundException {
    test("test08", "1.1", false);
  }

  @Test
  public void interpretComparisons() throws CompilationTimeException, FileNotFoundException {
    test("test09", "1.1", false);
  }

  @Test
  public void interpretFalseIf() throws CompilationTimeException, FileNotFoundException {
    test("test10", "1.1", false);
  }

  @Test(expected = CompilationTimeException.class)
  public void interpretWrongBooleanAssignation()
      throws CompilationTimeException, FileNotFoundException {
    test("test11", "1.1", false);
  }

  @Test
  public void interpretConst() throws CompilationTimeException, FileNotFoundException {
    test("test12", "1.1", false);
  }

  @Test(expected = CompilationTimeException.class)
  public void interpretConstReasignationShouldFail()
      throws CompilationTimeException, FileNotFoundException {
    test("test13", "1.1", false);
  }

  @Test(expected = CompilationTimeException.class)
  public void ifStatementWithNumber() throws CompilationTimeException, FileNotFoundException {
    test("test14", "1.1", false);
  }

  @Test
  public void testLeftVariableInOperation() throws CompilationTimeException, FileNotFoundException {
    test("test15", "1.1", false);
  }

  @Test
  public void printDivOfDouble() throws CompilationTimeException, FileNotFoundException {
    test("test16", "1.1", false);
  }

  @Test
  public void ifStatementWithAllOperationsAndPrint()
      throws CompilationTimeException, FileNotFoundException {
    test("test17", "1.1", false);
  }

  @Test(expected = CompilationTimeException.class)
  public void numberToBooleanAssignmentShouldFail()
      throws CompilationTimeException, FileNotFoundException {
    test("test18", "1.1", false);
  }

  @Test
  public void testStringWithAWordFromAPriorityOneTokenWithSpace()
      throws CompilationTimeException, FileNotFoundException {
    test("test19", "1.1", false);
  }

  @Test
  public void testStringWithAWordFromAPriorityOneTokenWithoutSpace()
      throws CompilationTimeException, FileNotFoundException {
    test("test20", "1.1", false);
  }

  public void test(String directory, boolean output)
      throws FileNotFoundException, CompilationTimeException {
    test(directory, "1.0", output);
  }

  public void test(String directory, String version, boolean output)
      throws FileNotFoundException, CompilationTimeException {
    String testDirectory = "src/test/resources/interpreter-tests/" + directory + "/";
    List<String> statements = readLines(testDirectory + "input.txt");
    List<String> expectedOutput = readLines(testDirectory + "output.txt");

    PrintCollector printCollector = new PrintCollector();

    OurLexer lexer = new LexerAdapter();
    lexer.setVersion(version);
    lexer.analyseLexically(Collections.singletonList(testDirectory + "input.txt"));

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    InterpreterVisitor interpreter = new InterpreterVisitorImpl(printCollector);

    if (output) interpreter.enablePrintProgress();

    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }

    Assert.assertEquals(expectedOutput, printCollector.getStatements());
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

  @Test
  public void testAdapter() throws FileNotFoundException, CompilationTimeException {
    test("test21", false);
  }
}
