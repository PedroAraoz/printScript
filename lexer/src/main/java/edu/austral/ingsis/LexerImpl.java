package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LexerImpl implements Lexer {
  
  private List<Token> tokens = new ArrayList<>();
  private String version = "1.0";
  
  public void setVersion(String version) {
    this.version = version;
  }
  
  @Override
  public void analyseLexically(List<String> code) {
    List<Token> tokens = new ArrayList<>();
    List<TokenIdentifier> one = TokenIdentifier.getPriorityOneTokens(version);
    List<TokenIdentifier> two = TokenIdentifier.getPriorityTwoTokens();
    List<TokenIdentifier> all = TokenIdentifier.getAllTokens(version);
    // PART 1 we split based on the no-space tokens (priorityOne)
    for (int i = 0; i < code.size(); i++)
      tokens.add(stringToEmptyToken(code.get(i), i, 0, 0));
    for (TokenIdentifier ti : one)
      tokens = findAndSplit(tokens, ti);
    
    
    // then we remove unnecessary spaces that might be there.
    doubleTrim(tokens);
    tokens = fixString(tokens);
    findAndReplace(tokens, two);
    tokens = removeSpacesInWIPToken(tokens);
    tokens = filterEmptyWIPToken(tokens);
    // then we find and replace the tokens in an important order.
    findAndReplace(tokens, all);
    removeQuotationMarkers(tokens);
    this.tokens = tokens;
  }
  
  private List<Token> fixString(List<Token> tokens) {
    final List<Token> answer = new ArrayList<>();
    String acc = "";
    boolean unClosed = false;
    int startPos = 0;
    for (int i = 0; i < tokens.size(); i++) {
      final Token token = tokens.get(i);
      if (containsQuations(token.getValue())) {
        if (!unClosed) {
          unClosed = true;
          acc = token.getValue();
          startPos = token.getStartPos();
        } else {
          unClosed = false;
          acc += " " + token.getValue();
          acc.replace("  ", " ");
          answer.add(stringToEmptyToken(acc, token.getLine(), startPos, startPos + acc.length()));
        }
      } else if (unClosed) {
        acc += " " + token.getValue();
      } else {
        answer.add(token);
      }
    }
    return answer;
  }
  
  private boolean containsQuations(String value) {
    final int length = value.length();
    final String replace1 = value.replace("\"", "");
    final String replace2 = value.replace("'", "");
    return length - replace1.length() == 1 ||
            length - replace2.length() == 1;
  }
  
  public List<Token> findAndSplit(List<Token> tokens, TokenIdentifier ti) {
    List<Token> list = new ArrayList<>();
    for (int i = 0; i < tokens.size(); i++) {
      final Token t = tokens.get(i);
      final String value = t.getValue();
      if (!specificCase(ti, value)) {
        final Pattern pattern = addLookaheadandLookbehind(ti.getRegex());
        final String[] split = pattern.split(value);
        int startpos = 0;
        for (String s : split) {
          int endpos = startpos + s.length() - 1;
          final Token token = stringToEmptyToken(s, t.getLine(),
                  t.getStartPos() + startpos, t.getEndPos() + endpos);
          startpos = endpos + 1;
          list.add(token);
        }
      } else {
        list.add(t);
      }
    }
    return list;
  }
  
  private boolean specificCase(TokenIdentifier ti, String value) {
    return ((ti.getName().equals(TokenName.VALUE_ASSIGNATION) ||
            ti.getName().equals(TokenName.GREATER) || ti.getName().equals(TokenName.LESSER))
            && (value.contains("<=") || value.contains(">=")));
  }
  
  public Pattern addLookaheadandLookbehind(Pattern p) {
    String regex = p.pattern();
    regex = "((?<=" + regex + ")|(?=" + regex + "))";
    return Pattern.compile(regex);
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
  
  @Override
  public Optional<Token> getNextToken() {
    try {
      return Optional.ofNullable(tokens.remove(0));
    } catch (IndexOutOfBoundsException _ignored) {
      return Optional.empty();
    }
  }
  
  @Override
  public Optional<Token> peek() {
    if (tokens.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.ofNullable(tokens.get(0));
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
