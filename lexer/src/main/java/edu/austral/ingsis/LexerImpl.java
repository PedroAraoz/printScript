package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LexerImpl implements Lexer {
  private final TokenDumper dumper = new TokenDumper();
//  private final TokenFactory tokenFactory = new TokenFactory(dumper);
  private final List<Token> tokenList = Token.getAllTokens();
  private StringBuilder stringBuilder = new StringBuilder();
  
  @Override
  public List<TokenWrapper> analyseLexically(CodeLine line) {
    final List<TokenWrapper> result = new ArrayList<>();
    final List<String> list = Arrays.asList(line.toString().split("(?!^)"));
    int startPos = 0;
    int endPos = 0;
    
    for (String c : list) {
      put(c);
      while (dumper.hasNext()) {
        // Create TokenWrapper. Add extra information needed
        final Tuple t = dumper.pop();
        endPos += stringBuilder.toString().length();
        result.add(new TokenWrapper(t.getToken(), line.getRow(), startPos, endPos, t.getOptional()));
        startPos = endPos;
      }
    }
    
    return result;
  }
  
  private void put(String c) {
    //Firstly we validate if the character is a token in and of itself
    Optional<Token> single = tokenList.stream().filter(t -> t.getRegex().matcher(c).matches()).findFirst();
    
    if (single.isPresent() && !single.get().equals(Token.LITERAL_TOKEN)) {
      String s = stringBuilder.toString();
      s = s.replace(" ", "");
      if (s.length() > 0) {
        // sientras aca es porque hubo un cambio de token y habia info apilada.
        dumper.dumpVariable(Token.VARIABLE_TOKEN, s);
        stringBuilder = new StringBuilder();
      }
      dumper.dump(single.get());
    }
    else if (single.isPresent() && single.get().equals(Token.VARIABLE_TOKEN)) {
      String s = stringBuilder.toString();
      s = s.replace(" ", "");
      if (s.length() > 0) {
        dumper.dumpVariable(Token.LITERAL_TOKEN, s);
        stringBuilder = new StringBuilder();
      }
      dumper.dump(single.get());
    }

    //If the character is not a token, we must add it to the StringBuilder and check as a whole
    else {

      stringBuilder.append(c);
      String s = stringBuilder.toString();

      // We separate the contents of the StringBuilder into different words separated by spaces. This is becase if a word has not been identified as a token, it is a variable name
      List<String> list = Arrays.asList(s.split(" "));

      // We need to filter the empty strings out of the list, because of how split() method works
      list = list.stream().filter(e -> !e.equals("")).collect(Collectors.toList());

      for (int i = 0; i < list.size(); i ++) {
        final String s1 = list.get(i);
        Optional<Token> tokenOptional = tokenList.stream().filter(t -> t.getRegex().matcher(s1).matches()).findFirst();
        if (tokenOptional.isPresent()) {
          for (int j = i - 1; j >= 0; j--) {
            dumper.dumpVariable(Token.VARIABLE_TOKEN, list.get(j));
          }
          dumper.dump(tokenOptional.get());
          stringBuilder = new StringBuilder();
        }
      }
    }
    
  }
}
//TODO los literal no estamos contemplando ponerles valores
