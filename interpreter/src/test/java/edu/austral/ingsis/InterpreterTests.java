package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class InterpreterTests {
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
  
  public void test(String directory, boolean output)
          throws FileNotFoundException, CompilationTimeException {
    String testDirectory = "src/test/resources/interpreter-tests/" + directory + "/";
    List<String> statements = readLines(testDirectory + "input.txt");
    List<String> expectedOutput = readLines(testDirectory + "output.txt");
    
    PrintCollector printCollector = new PrintCollector();
    
    Lexer lexer = new LexerImpl();
    lexer.analyseLexically(statements);
    
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
}
