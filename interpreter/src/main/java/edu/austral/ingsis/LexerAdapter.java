package edu.austral.ingsis;

import java.util.List;
import java.util.Optional;

public class LexerAdapter implements OurLexer {
  
  private final Lexer lexer = new ConcreteLexer();
  
  @Override
  public void analyseLexically(List<String> string) {
    final String path = string.get(0);
    final List<Token> scan = lexer.scan(path);
    System.out.println("asd");
  }
  
  @Override
  public Optional<Token> getNextToken() {
    return Optional.empty();
  }
  
  @Override
  public boolean hasNext() {
    return false;
  }
  
  @Override
  public List<Token> getAll() {
    return null;
  }
  
  @Override
  public void setVersion(String version) {
  
  }
  
  @Override
  public Optional<Token> peek() {
    return Optional.empty();
  }
}
