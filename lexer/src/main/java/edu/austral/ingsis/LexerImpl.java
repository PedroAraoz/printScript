package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LexerImpl implements Lexer {
  private final TokenDumper dumper = new TokenDumper();
  private final List<TokenIdentifier> tokenIdentifierList = TokenIdentifier.getAllTokens();
  private StringBuilder stringBuilder = new StringBuilder();

  @Override
  public List<Token> analyseLexically(CodeLine line) {
    int startPos = 0;
    int endPos;
    final List<Token> result = new ArrayList<>();
    final List<String> list = Arrays.asList(line.toString().split("(?!^)"));

    list.forEach(this::put);
    final String s = stringBuilder.toString().replace(" ", "");
    if (s.length() > 0) dumpVarOrLit(s);

    while (dumper.hasNext()) {
      // Create Token Add extra information needed
      final Tuple t = dumper.pop();
      endPos = startPos + t.getString().length();
      result.add(new Token(t.getToken(), line.getRow(), startPos, endPos, t.getString()));
      startPos = endPos;
    }
    // todo el manejo de pos podria ser mejor
    return result;
  }

  private void put(String c) {
    // Firstly we validate if the character is a token in and of itself
    Optional<TokenIdentifier> single =
        tokenIdentifierList.stream().filter(t -> t.getRegex().matcher(c).matches()).findFirst();

    if (single.isPresent() && (!single.get().equals(TokenIdentifier.NUMBER_LITERAL_TOKEN) || !single.get().equals(TokenIdentifier.STRING_LITERAL_TOKEN))) {
      String s = stringBuilder.toString();
      s = s.replace(" ", "");
      if (s.length() > 0) {
        // Aca podemos tener en s o un token o una variable.
        dumpVarOrLit(s);
      }
      dumper.dump(single.get(), c);
    }
    // If the character is not a token, we must add it to the StringBuilder and check as a whole
    else {

      stringBuilder.append(c);
      String s = stringBuilder.toString();

      // We separate the contents of the StringBuilder into different words separated by spaces.
      // This is because if a word has not been identified as a token, it is a variable name
      List<String> list = Arrays.asList(s.split(" "));

      // We need to filter the empty strings out of the list, because of how split() method works
      list = list.stream().filter(e -> !e.equals("")).collect(Collectors.toList());

      for (int i = 0; i < list.size(); i++) {
        final String s1 = list.get(i);
        Optional<TokenIdentifier> tokenOptional = tokenIdentifierList.stream().filter(t -> matches(t, s1)).findFirst();
        if (tokenOptional.isPresent()) {
          for (int j = i - 1; j >= 0; j--) dumpVarOrLit(list.get(j));
          dumper.dump(tokenOptional.get(), s1);
          stringBuilder = new StringBuilder();
        }
      }
    }
  }

  private boolean matches(TokenIdentifier t, String s) {
    return t.getRegex().matcher(s).matches();
  }

  private void dumpVarOrLit(String s) {
    if (matches(TokenIdentifier.NUMBER_LITERAL_TOKEN, s)) {
      dumper.dump(TokenIdentifier.NUMBER_LITERAL_TOKEN, s);
    } else if(matches(TokenIdentifier.STRING_LITERAL_TOKEN, s)) {
      dumper.dump(TokenIdentifier.STRING_LITERAL_TOKEN, s);
    } else {
      dumper.dump(TokenIdentifier.VARIABLE_TOKEN, s);
    }
    stringBuilder = new StringBuilder();
  }
}
