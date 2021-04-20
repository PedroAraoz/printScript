package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LexerImpl implements Lexer {
  
  List<Token> tokens = new ArrayList<>();
  
  @Override
  public void analyseLexically(List<String> code) {
    List<Token> tokens = new ArrayList<>();
    List<TokenIdentifier> one = TokenIdentifier.getPriorityOneTokens();
    List<TokenIdentifier> all = TokenIdentifier.getAllTokens();
    // PART 1 (no space needed tokens)
    for (int i = 0; i < code.size(); i++)
      tokens.add(stringToEmptyToken(code.get(i), i, 0, 0));
    for (TokenIdentifier ti : one)
      tokens = findReplaceAndSplit(tokens, ti);
      
    
    // PART 2 (String and number literals)
    doubleTrim(tokens);
//    findAndReplace(tokens, two);
    tokens = removeSpacesInWIPToken(tokens);
    tokens = filterEmptyWIPToken(tokens);
    // PART 3
    findAndReplace(tokens, all);
    removeQuotationMarkers(tokens);
    this.tokens = tokens;
  }
  
  public List<Token> findReplaceAndSplit(List<Token> tokens, TokenIdentifier ti) {
    List<Token> AAAA = new ArrayList<>();
    for (int i = 0; i < tokens.size(); i++) {
      final Token t = tokens.get(i);
      final String value = t.getValue();
      final Pattern pattern = addLookaheadandLookbehind(ti.getRegex());
      final String[] split = pattern.split(value);
      int startpos = 0;
      for (String s : split) {
        int endpos = startpos + s.length() - 1;
        final Token token = stringToEmptyToken(s, t.getLine(),
                t.getStartPos() + startpos, t.getEndPos() + endpos);
        startpos = endpos + 1;
        AAAA.add(token);
      }
    }
    return AAAA;
  }
  
  public Pattern addLookaheadandLookbehind(Pattern p) {
    String regex = p.pattern();
    regex = "((?<=" + regex + ")|(?=" + regex + "))";
    return Pattern.compile(regex);
  }
  
  private List<String> getMatches(Pattern regex, String text) {
    final List<String> list = new ArrayList<>();
    final Matcher matcher = regex.matcher(text);
    while (matcher.find()) list.add(matcher.group());
    return list;
  }
  
  private void findAndReplace(List<Token> tokens, List<TokenIdentifier> two) {
    for (TokenIdentifier ti : two) {
      for (int i = 0; i < tokens.size(); i++) {
        Token t = tokens.get(i);
        if (t.getName().equals(TokenName.WIP_TOKEN)) {
          if (ti.verify(t.getValue())) {
            tokens.set(i, new Token(ti, t.getLine(), t.getStartPos(), t.getEndPos(), t.getValue()));
          }
        }
      }
    }
  }
  
  private void doubleTrim(List<Token> tokens) {
    for (int i = 0; i < tokens.size(); i++) {
      final Token t = tokens.get(i);
      if (t.getName().equals(TokenName.WIP_TOKEN)) {
        int originalSize = t.getValue().length();
        String trimmed = t.getValue().trim();
        int deltaStart = trimmed.length() - originalSize;
        final String reversed = new StringBuilder(trimmed).reverse().toString();
        int originalReversedSize = reversed.length();
        String reverseTrimmed = reversed.trim();
        int deltaEnd = reverseTrimmed.length() - originalReversedSize;
        final String finalString = new StringBuilder(reverseTrimmed).reverse().toString();
        Token token = stringToEmptyToken(finalString, t.getLine(),
                t.getStartPos() + deltaStart, t.getEndPos() - deltaEnd);
        tokens.set(i, token);
      }
    }
  }
  
  private List<Token> removeSpacesInWIPToken(List<Token> tokens) {
    final List<Token> answer = new ArrayList<>();
    for (Token t : tokens) {
      if (t.getName().equals(TokenName.WIP_TOKEN)) {
        final List<String> strings = Arrays.asList(t.getValue().split(" "));
        int startPos = t.getStartPos();
        int endPos;
        for (String s : strings) {
          endPos = startPos + s.length();
          answer.add(stringToEmptyToken(
                  s, t.getLine(), startPos, endPos));
          startPos = endPos + 1;
        }
      } else {
        answer.add(t);
      }
    }
    return answer;
  }
  
  private void removeQuotationMarkers(List<Token> tokens) {
    for (Token t : tokens) {
      if (t.getName().equals(TokenName.STRING_LITERAL)) {
        t.setValue(t.getValue().substring(1, t.getValue().length() - 1));
        t.setStartPos(t.getStartPos() + 1);
        t.setEndPos(t.getEndPos() - 1);
      }
    }
  }
  private List<Token> filterEmptyWIPToken(List<Token> tokens) {
    return tokens.stream().filter(e -> !e.getValue().equals("")).collect(Collectors.toList());
  }
  
  public Token stringToEmptyToken(String string, int line, int s, int e) {
    return new Token(TokenIdentifier.WIP_TOKEN, line, s, e, string);
  }
  
  public Optional<Token> getNextToken() {
    try {
      return Optional.ofNullable(tokens.remove(0));
    } catch (IndexOutOfBoundsException _ignored) {
      return Optional.empty();
    }
  }
  
  @Override
  public boolean hasNext() {
    return !tokens.isEmpty();
  }
  
  @Override
  public List<Token> getAll() {
    return tokens;
  }
}