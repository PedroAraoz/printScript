package edu.austral.ingsis;

import edu.austral.ingsis.fileGenerator.FileGenerator;

public class StateFactory {
  
  private final State execute, validate;
  
  public StateFactory(CLI cli, Lexer lexer, Parser parser, InterpreterVisitor interpreter, FileGenerator fileGenerator, Printer printer) {
    execute = new StateExecuter(lexer, parser, interpreter, fileGenerator, this, printer);
    validate = new StateValidator(lexer, parser, fileGenerator, this, printer);
    cli.changeState(execute); //default state
  }
  
  public State get(String name) {
    switch (name) {
      case "execute": return execute;
      case "validate": return validate;
      default: throw new RuntimeException("Invalid command. Can only run in 'execute' or 'validate' modes");
    }
  }
  
}
