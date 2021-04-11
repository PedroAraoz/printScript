package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CLI {
  private State state;
  private final Printer printer;
  
  public CLI() {
    //todo probablemente cambiar esto
    printer = new CLIPrinter();
    Lexer lexer = new LexerImpl();
    VariableRegister variableRegister = new VariableRegister();
    Parser parser = new ParserImpl();
    Interpreter interpreter = new InterpreterImpl();
    FileGenerator fileGenerator = new NormalFileGenerator();
    final StateFactory stateFactory = new StateFactory(this, lexer, parser, interpreter, fileGenerator);
    state = stateFactory.get("execute"); //default
  }

  public void changeState(State state) {
    this.state = state;
    state.setContext(this);
  }
  
  public void run() throws FileNotFoundException, CompilationTimeException {
    final Scanner scanner = new Scanner(System.in);
    String message = "";
    String welcomeMessage = "please type\n" +
            "<mode> <filePath>\n>";
    print(welcomeMessage);
    while (!message.equals("exit")) {
//      message = scanner.nextLine().trim().toLowerCase();
      message = "execute state/src/main/resources/test.txt";
      final String[] args = message.split(" ");
      if (args.length != 2) throw new RuntimeException("AAAAA"); //todo implement mejor
      //todo por algun lugar mirar que este bien armando con mode filepath
      final List<String> logs = state.run(args);
      print(logs);
    }
  }
  
  public void print(String s) {
    printer.print(s);
  }
  
  public void print(List<String> strings) {
    strings.forEach(this::print);
  }
}
