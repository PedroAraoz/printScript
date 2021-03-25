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
    //single
    Optional<Token> single = tokenList.stream().filter(t -> t.getRegex().matcher(c).matches()).findFirst();
    if (single.isPresent()) {
      String s = stringBuilder.toString();
      s = s.replace(" ", "");
      if (s.length() > 0) {
        dumper.dumpVariable(Token.VARIABLE_TOKEN, s);
        stringBuilder = new StringBuilder();
      }
      dumper.dump(single.get());
    } else {
      stringBuilder.append(c);
      String s = stringBuilder.toString();
      List<String> list = Arrays.asList(s.split(" "));
      list = list.stream().filter(e -> !e.equals("")).collect(Collectors.toList());
      System.out.println("asd");
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