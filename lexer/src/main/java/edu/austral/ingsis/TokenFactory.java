package edu.austral.ingsis;

import java.util.List;
import java.util.Optional;

public class TokenFactory {

  private final List<Token> tokenList;
  private StringBuilder stringBuilder = new StringBuilder();
  private final TokenDumper dumper;
  public TokenFactory(TokenDumper dumper) {
    this.tokenList = Token.getAllTokens();
    this.dumper = dumper;
  }

  // This method receives characters one by one from the lexer
  public void put(String c) {
    stringBuilder.append(c);
    Optional<Token> tokenOptional = tokenList.stream().filter(t -> t.getRegex().matcher(stringBuilder.toString()).matches()).findFirst();
    if (tokenOptional.isPresent()) {
      if (tokenOptional.get().getName().equals(TokenName.LITERAL) || tokenOptional.get().getName().equals(TokenName.VARIABLE)) {
        dumper.dumpVariable(tokenOptional.get(), stringBuilder.toString());
      } else {
        dumper.dump(tokenOptional.get());
      }
      stringBuilder = new StringBuilder();
    }
  }
}
