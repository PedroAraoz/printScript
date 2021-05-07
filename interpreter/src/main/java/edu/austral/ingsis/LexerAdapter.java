package edu.austral.ingsis;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class LexerAdapter implements OurLexer {

  private final Lexer lexer = new ConcreteLexer();
  private List<Token> result = new ArrayList<>();
  private List<OurToken> ourTokens = new ArrayList<>();

  @Override
  public void analyseLexically(List<String> string) {
    final String path = string.get(0);
    File file = new File(path);
    result = lexer.scan(file);

    TokenMapper tokenMapper = new TokenMapper();
    for (Token token : result) {
      ourTokens.add(tokenMapper.convert(token));
    }
  }

  @Override
  public Optional<OurToken> getNextToken() {
    try {
      return Optional.ofNullable(ourTokens.remove(0));
    } catch (IndexOutOfBoundsException _ignored) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<OurToken> peek() {
    if (ourTokens.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.ofNullable(ourTokens.get(0));
    }
  }

  @Override
  public boolean hasNext() {
    return !ourTokens.isEmpty();
  }

  @Override
  public List<OurToken> getAll() {
    return ourTokens;
  }

  @Override
  public void setVersion(String version) {
    if (version.equals("1.1"))
      TokenCleanUp.activateTokens();
  }
}
