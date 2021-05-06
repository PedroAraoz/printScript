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
    // todo aca tambien con el error handler
    // todo mirar que el parser no printea.
    if (!checkMode(args[0])) return;
    final File file = fileGenerator.open(args[1]);
    printer.print("Starting...");
    final List<String> lines = new ArrayList<>();
    while (file.hasNext()) lines.add(file.next());
    printer.print("Lexing...");
    lexer.analyseLexically(lines);
    printer.print("Parsing...");
    parser.analyseSintactically(lexer);
    printer.print("JOB DONE!");
  }
  
  private boolean checkMode(String mode) {
    if (mode.equals("syntax")) return true;
    cli.changeState(stateFactory.get(mode));
    return false;
  }
}
