package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SemanticValidator implements State {
  
  private CLI cli;
  private final Lexer lexer;
  private final Parser parser;
  private final FileGenerator fileGenerator;
  private final StateFactory stateFactory;
  public SemanticValidator(Lexer lexer, Parser parser, FileGenerator fileGenerator, StateFactory stateFactory) {
    this.lexer = lexer;
    this.parser = parser;
    this.fileGenerator = fileGenerator;
    this.stateFactory = stateFactory;
  }
  
  @Override
  public void setContext(CLI cli) {
    this.cli = cli;
  }
  
  @Override
  public List<String> run(String[] args) throws FileNotFoundException {
    return validateSemantically(args);
  }
  
  private List<String> validateSemantically(String[] args) throws FileNotFoundException {
    // todo capaz a este nivel conviene tener un error handler o algo. tipo
    // que le pasas los errores y ese se comunica con el cli/print y los escupe
    // en vez de tener ese throws Error feo
    if (!checkMode(args[0])) return Collections.emptyList();
    final File file = fileGenerator.open(args[1]);
    //todo vvvvvv cambiar eso
    List<List<TokenWrapper>> cambiarEsto = new ArrayList<>();
    while (file.hasNext())
      cambiarEsto.add(lexer.analyseLexically(file.next().get()));
    List<AbstractSyntaxTree> list = new ArrayList<>();
    for (List<TokenWrapper> l : cambiarEsto)
      list.add(parser.analyseSintactically(l));
    //todo seguir implementando
    return null;
  }
  
  private boolean checkMode(String mode) {
    if (mode.equals("semantic")) return true;
    cli.changeState(stateFactory.get(mode));
    return false;
  }
}
