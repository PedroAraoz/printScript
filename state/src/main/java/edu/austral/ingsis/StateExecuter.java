package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StateExecuter implements State {

  private CLI cli;
  private final Lexer lexer;
  private final Parser parser;
  private final InterpreterVisitor interpreter;
  private final FileGenerator fileGenerator;
  private final StateFactory stateFactory;
  private final Printer printer;
  private boolean outputEnabled;

  public StateExecuter(Lexer lexer, Parser parser, InterpreterVisitor interpreter, FileGenerator fileGenerator, StateFactory stateFactory, Printer printer) {
    this.lexer = lexer;
    this.parser = parser;
    this.interpreter = interpreter;
    this.fileGenerator = fileGenerator;
    this.stateFactory = stateFactory;
    this.printer = printer;
  }

  @Override
  public void setContext(CLI cli) {
    this.cli = cli;
  }

  @Override
  public void run(String[] args) throws FileNotFoundException, CompilationTimeException {
    execute(args);
  }

  private void execute(String[] args) throws FileNotFoundException, CompilationTimeException {
    toggleOutput(args[3]);
    if (!checkMode(args[0])) {
      cli.run(args);
      return;
    }
    final File file = fileGenerator.open(args[1]);
    output("Starting...");
    final List<String> lines = new ArrayList<>();
    while (file.hasNext()) lines.add(file.next());
    lexer.setVersion(args[2]);
    output("Lexing....");
    lexer.analyseLexically(lines);
    output("Parsing....");
    final List<AbstractSyntaxTree> abstractSyntaxTrees = parser.analyseSintactically(lexer);
    final int total = abstractSyntaxTrees.size() - 1;
    int counter = 0;
    for (AbstractSyntaxTree ast : abstractSyntaxTrees) {
      output(counter + "/" + total);
      interpreter.visit(ast);
      counter++;
    }
    ((InterpreterVisitorImpl) interpreter).debug();
    output("JOB DONE!");
  }

  private void toggleOutput(String arg) {
    if (arg.equals("output-enabled=true")) {
      outputEnabled = true;
      interpreter.enablePrintProgress();
    } else if (arg.equals("output-enabled=false")) {
      outputEnabled = false;
      interpreter.disablePrintProgress();
    } else throw new RuntimeException("output-enabled was not set correctly");
  }

  private void output(String message) {
    if (outputEnabled)
      printer.print(message);
  }

  private boolean checkMode(String mode) {
    if (mode.equals("execute")) return true;
    cli.changeState(stateFactory.get(mode));
    return false;
  }
}
