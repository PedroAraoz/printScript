import edu.austral.ingsis.*;
import edu.austral.ingsis.exception.CompilationTimeException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    statements.add("printLn(1);");

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
    statements.add("let pi: number;");
    statements.add("pi = 3.14;");
    statements.add("printLn(pi / 2);");

    lexer.analyseLexically(statements);

    Parser parser = new ParserImpl();

    List<AbstractSyntaxTree> trees = parser.analyseSintactically(lexer);

    InterpreterVisitor interpreter = new InterpreterVisitorImpl(new CLIPrinter());

    for (AbstractSyntaxTree tree : trees) {
      interpreter.visit(tree);
    }
  }
}
