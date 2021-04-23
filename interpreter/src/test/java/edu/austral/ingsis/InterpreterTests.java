package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterpreterTests {
  
  @Test
  public void createInterpreter() {
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    assert interpreter != null;
  }
  
  @Test
  public void interpretBooleanDeclarationStatement() throws CompilationTimeException {
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    AbstractSyntaxTree abstractSyntaxTree = new VariableSyntaxLeaf();
    abstractSyntaxTree.setToken(new Token(TokenIdentifier.VARIABLE_TOKEN, 0, 0, 0, "x"));
    AbstractSyntaxTree second = new TypeAssignationSyntaxBranch();
    second.setToken(new Token(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    abstractSyntaxTree = abstractSyntaxTree.add(second);
    second = new BooleanTypeSyntaxLeaf();
    second.setToken(new Token(TokenIdentifier.BOOLEAN_TYPE_TOKEN, 0, 0, 0, "boolean"));
    abstractSyntaxTree = abstractSyntaxTree.add(second);
    
    interpreter.visit(abstractSyntaxTree);
  }
  
  @Test
  public void interpretTrueGreaterThan() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean;");
    statements.add("x = 2 > 1;");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretFalseGreaterThan() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean;");
    statements.add("x = 1 > 2;");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test(expected = CompilationTimeException.class)
  public void interpretWrongBooleanAssignation() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean;");
    statements.add("x = 2;");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test(expected = CompilationTimeException.class)
  public void interpretWrongGreaterThanAssignation() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: number;");
    statements.add("x = 2 > 1;");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretLesserThanAssignation() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean;");
    statements.add("x = 2 < 1;");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretLesserEqualsThanAssignation() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean;");
    statements.add("x = 2 <= 1;");
    
    lexer.analyseLexically(statements);
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretGreaterEqualsThanAssignation() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean;");
    statements.add("x = 2 >= 1;");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretEmptyIf() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean = true;");
    statements.add("if (x) {}");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretTrueEmptyIfElse() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean = true;");
    statements.add("if (x) {} else {}");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretFalseEmptyIfElse() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean = true;");
    statements.add("if (x) {} else {}");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretTrueIfElseOneStatement() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean = true;");
    statements.add("if (x) {x = false;} else {}");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretFalseIfElseOneStatement() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean = false;");
    statements.add("if (x) {} else {x = false;}");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretTrueIfElseMultipleStatements() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("let x: boolean = false;");
    statements.add("if (x) {x = false;y: number = 1;y = 3;} else {x = false;}");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test
  public void interpretConst() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("const x: boolean = false;");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
  
  @Test(expected = CompilationTimeException.class)
  public void interpretConstReasignationShouldFail() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");
    
    List<String> statements = new ArrayList<>();
    statements.add("const x: boolean = false;");
    statements.add("x = true;");
    
    lexer.analyseLexically(statements);
    
    Parser parser = new ParserImpl();
    
    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);
    
    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());
    
    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }

  @Test(expected = CompilationTimeException.class)
  public void ifStatementWithNumber() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");

    List<String> statements = new ArrayList<>();
    statements.add("let x: number = 21;");
    statements.add("if (x) {}");

    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());

    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }

  @Test
  public void testPrintLnWithNumbers() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");

    List<String> statements = new ArrayList<>();
    statements.add("println(1);");

    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());

    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }

  @Test
  public void testLeftVariableInOperation() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");

    List<String> statements = new ArrayList<>();
    statements.add("let three: number = 3;");
    statements.add("let two: number;");
    statements.add("two = three + 1;");

    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());

    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }

  @Test
  public void printDivOfDouble() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");

    List<String> statements = new ArrayList<>();
    statements.add("let a: number;");
    statements.add("a = 3.5;");
    statements.add("println(a * 2);");

    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());

    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }

  @Test
  public void asdasdasdasdasdasdasdASDS() throws FileNotFoundException, CompilationTimeException {
    final NormalFileGenerator normalFileGenerator = new NormalFileGenerator();
    final File open = normalFileGenerator.open("src/test/resources/myCode.txt");
    List<String> strings = new ArrayList<>();
    while (open.hasNext()) strings.add(open.next());
    LexerImpl lexer = new LexerImpl();
    lexer.setVersion("1.1");
    lexer.analyseLexically(strings);
    ParserImpl parser = new ParserImpl();
    final List<Token> all = lexer.getAll();


    System.out.println("asd");
    final List<AbstractSyntaxTree> abstractSyntaxTrees = parser.analyseSintactically(lexer);
    InterpreterVisitorImpl i = new InterpreterVisitorImpl(new CLIPrinter());
    for (AbstractSyntaxTree ast : abstractSyntaxTrees) {
      i.visit(ast);
      i.debug();
    }
  }

  @Test
  public void ifStatementWithGreaterAndPrint() throws CompilationTimeException {
    Lexer lexer = new LexerImpl();
    lexer.setVersion("1.1");

    List<String> statements = new ArrayList<>();
    statements.add("const x: boolean = 2 > 1;");
    statements.add("if(x) {println(\"Yeaaaaaah\");}");
    statements.add("println(\"my job here is done\");");

    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());

    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }

  @Test
  public void interpreterTestsFromFile() throws FileNotFoundException, CompilationTimeException {
    List<String> directories = new ArrayList<>();
    directories.add("test01");
    directories.add("test02");

    for (String directory : directories) {
      test(directory);
    }
  }

  public void test(String directory) throws FileNotFoundException, CompilationTimeException {
    String testDirectory = "src/test/resources/interpreter-tests/" + directory + "/";
    List<String> statements = readLines(testDirectory + "input.txt");
    List<String> expectedOutput = readLines(testDirectory + "output.txt");

    PrintCollector printCollector = new PrintCollector();

    Lexer lexer = new LexerImpl();

    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    InterpreterVisitor interpreter = new InterpreterVisitorImpl(printCollector);

    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }

    Assert.assertEquals(expectedOutput, printCollector.getStatements());
  }

  private List<String> readLines(String file) throws FileNotFoundException {
    Scanner s = new Scanner(new java.io.File(file));
    ArrayList<String> list = new ArrayList<>();
    while (s.hasNextLine()){
      list.add(s.nextLine());
    }
    s.close();
    return list;
  }
}
