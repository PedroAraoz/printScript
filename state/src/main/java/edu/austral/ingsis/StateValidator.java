package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import edu.austral.ingsis.fileGenerator.File;
import edu.austral.ingsis.fileGenerator.FileGenerator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StateValidator implements State {

  private CLI cli;
  private final Lexer lexer;
  private final Parser parser;
  private final FileGenerator fileGenerator;
  private final StateFactory stateFactory;
  private final Printer printer;
  private boolean outputEnabled;

  public StateValidator(Lexer lexer, Parser parser, FileGenerator fileGenerator, StateFactory stateFactory, Printer printer) {
    this.lexer = lexer;
    this.parser = parser;
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
    analyzeSintactically(args);
  }

  private void analyzeSintactically(String[] args) throws FileNotFoundException, CompilationTimeException {
    toggleOutput(args[3]);
    if (!checkMode(args[0])) return;
    final File file = fileGenerator.open(args[1]);
    output("Starting...");
    final List<String> lines = new ArrayList<>();
    while (file.hasNext()) lines.add(file.next());
    lexer.setVersion(args[2]);
    output("Lexing...");
    lexer.analyseLexically(lines);
    output("Parsing...");
    parser.analyseSintactically(lexer);
    output("JOB DONE!");
  }

  private void output(String message) {
    if (outputEnabled)
      printer.print(message);
  }

  private void toggleOutput(String arg) {
    if (arg.equals("output-enabled=true")) outputEnabled = true;
    else if (arg.equals("output-enabled=false")) outputEnabled = false;
    else throw new RuntimeException("output-enabled was not set correctly");
  }

  private boolean checkMode(String mode) {
    if (mode.equals("validate")) return true;
    cli.changeState(stateFactory.get(mode));
    return false;
  }
}
