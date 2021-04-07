package edu.austral.ingsis;

public class StateFactory {
  
  private final State execute, syntax, semantic;
  
  public StateFactory(CLI cli, Lexer lexer, Parser parser, Interpreter interpreter, FileGenerator fileGenerator) {
    execute = new Executer(lexer, parser, interpreter, fileGenerator, this);
    syntax = new SyntaxValidator(lexer, parser, fileGenerator, this);
    semantic = new Executer(lexer, parser, interpreter, fileGenerator, this);
  }
  
  public State get(String name) {
    switch (name) {
      case "execute": return execute;
      case "syntax": return syntax;
      case "semantic": return semantic;
      default: throw new RuntimeException("Command invalid something"); //todo implement correclty
    }
  }
  
}
