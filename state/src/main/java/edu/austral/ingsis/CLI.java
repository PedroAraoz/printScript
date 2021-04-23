package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CLI {
  private State state;
  private final Printer printer;
  
  public CLI(Printer printer) {
    //todo probablemente cambiar esto
    this.printer = printer;
    Lexer lexer = new LexerImpl();
    Parser parser = new ParserImpl();
    final InterpreterVisitorImpl interpreter = new InterpreterVisitorImpl(printer);
    FileGenerator fileGenerator = new NormalFileGenerator();
    final StateFactory stateFactory = new StateFactory(this, lexer, parser, interpreter, fileGenerator, printer);
  }

  public void changeState(State state) {
    this.state = state;
    state.setContext(this);
  }
  
  public void run(String message) throws FileNotFoundException, CompilationTimeException {
    final String[] args = message.split(" ");
    if (args.length < 3) throw new RuntimeException("Three arguments are needed"); //todo implement mejor
    state.run(args);
  }
  
  public void run() throws FileNotFoundException, CompilationTimeException {
    final Scanner scanner = new Scanner(System.in);
    String message = "";
    String welcomeMessage = "please type\n" +
            "<mode> <filePath> <versionNumber>";
    printer.print(welcomeMessage);
    message = scanner.nextLine().trim().toLowerCase();
    while (!message.equals("exit")) {
      printer.print(">");
      final String[] args = message.split(" ");
      if (args.length < 3) throw new RuntimeException("Three arguments are needed");
      state.run(args);
      message = scanner.nextLine().trim().toLowerCase();
    }
  }
}
