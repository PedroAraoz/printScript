package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.io.FileNotFoundException;
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
    final int totalLines = file.getLines();
    int currentLine = 0;
    lexer.setVersion(args[2]);
    while (file.hasNext()) {
      printer.print(currentLine + "/" + totalLines);
      final List<Token> tokenWrappers = lexer.analyseLexically(file.next().get());
      parser.analyseSintactically(tokenWrappers);
      currentLine++;
    }
  }
  
  private boolean checkMode(String mode) {
    if (mode.equals("syntax")) return true;
    cli.changeState(stateFactory.get(mode));
    return false;
  }
}
