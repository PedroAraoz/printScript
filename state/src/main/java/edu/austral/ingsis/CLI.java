package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CLI {
  private State state;
  private Printer printer;
  
  public CLI() {
    //todo probablemente cambiar esto
    Lexer lexer = new LexerImpl();
    VariableRegister variableRegister = new VariableRegister();
    Parser parser = new ParserImpl(variableRegister);
    Interpreter interpreter = new InterpreterImpl(variableRegister);
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
      message = scanner.nextLine().trim().toLowerCase();
      final String[] args = message.split(" ");
      if (args.length != 2) throw new RuntimeException("AAAAA"); //todo implement mejor
      //todo por algun lugar mirar que este bien armando con mode filepath
      state.run(args);
    }
  }
  
  public void print(String s) {
    //todo implement
    System.out.println(s);
  }
}
