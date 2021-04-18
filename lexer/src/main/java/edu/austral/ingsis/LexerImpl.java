package edu.austral.ingsis;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LexerImpl implements Lexer {
  
  List<Token> tokens = new ArrayList<>();
  
  @Override
  public void analyseLexically(List<String> code) {
    List<Token> tokens = new ArrayList<>();
    List<TokenIdentifier> one = TokenIdentifier.getPriorityOneTokens();
    List<TokenIdentifier> two = TokenIdentifier.getPriorityTwoTokens();
    List<TokenIdentifier> three = TokenIdentifier.getPriorityThreeTokens();
    // PART 1 (no space needed tokens)
    for (int i = 0; i < code.size(); i++)
      tokens.add(stringToEmptyToken(code.get(i), i, 0, -1)); //the -1 does not matter
    for (TokenIdentifier i : one)
      tokens = findAndReplace(tokens, i);
    
    // PART 2 (String and number literals)
    for (TokenIdentifier i : two)
      tokens = findAndReplaceTwo(tokens, i);
    removeQuotationMarkers(tokens);
    tokens = removeSpacesInWIPToken(tokens);
    tokens = filterEmptyWIPToken(tokens);
    // PART 3
    for (TokenIdentifier ti : three) {
      for (int i = 0; i < tokens.size(); i++) {
        Token t = tokens.get(i);
        if (t.getName().equals(TokenName.WIP_TOKEN)) {
          if (ti.verify(t.getValue())) {
            tokens.set(i, new Token(ti, t.getLine(), t.getStartPos(), t.getEndPos(), t.getValue()));
          } else {
            tokens.set(i, t);
          }
        } else {
          tokens.set(i, t);
        }
      }
    }
    this.tokens = tokens;
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
  
  private List<Token> findAndReplaceTwo(List<Token> tokens, TokenIdentifier ti) {
    final List<Token> answer = new ArrayList<>();
    for (Token t : tokens) {
      if (t.getName().equals(TokenName.WIP_TOKEN)) {
        final String string = t.getValue();
        final Matcher matcher = ti.getRegex().matcher(string);
        List<String> matches = matcher.results().map(MatchResult::group).collect(Collectors.toList());
        if (matches.isEmpty()) {
          answer.add(t);
        }
        for (String s : matches) {
          final List<String> strings = Arrays.asList(string.split(s));
          final List<Token> wat = findAndReplace(string, strings, ti, t.getLine(), t.getStartPos(), s.length() - 1, s);
          answer.addAll(wat);
        }
      } else {
        answer.add(t);
      }
    }
    return answer;
  }
  
  private List<Token> findAndReplace(String original, List<String> list, TokenIdentifier token, int line, int startPos, int tokenStep, String tokenValue) {
    final List<Token> tokens = new ArrayList<>();
    int endPos = 0;
    if (list.get(0).equals("")) {
      //esto significa que habia un token en posicion 0
      tokens.add(new Token(token, line, startPos, startPos, token.toString()));
      startPos++;
    }
    for (int i = 0; i < list.size() - 1; i++) {
      endPos += list.get(i).length() - 1;
      tokens.add(stringToEmptyToken(list.get(i), line, startPos, endPos));
      startPos = endPos + 1;
      endPos = startPos + tokenStep;
      tokens.add(new Token(token, line, startPos, endPos, tokenValue));
      startPos = endPos + 1;
    }
    endPos = startPos + list.get(list.size() - 1).length() - 1;
    tokens.add(stringToEmptyToken(list.get(list.size() - 1), line, startPos, endPos));
    startPos = endPos + 1;
    if (token.verify(original.substring(original.length() - tokenStep - 1))) {
      tokens.add(new Token(token, line, startPos, startPos + tokenStep, tokenValue));
    }
    return tokens;
  }
  
  private List<Token> filterEmptyWIPToken(List<Token> tokens) {
    return tokens.stream().filter(e -> !e.getValue().equals("")).collect(Collectors.toList());
  }
  
  private List<Token> findAndReplace(String string, TokenIdentifier token, int line, int startPos) {
    final List<String> list = Arrays.asList(token.getRegex().split(string));
    int tokenStep = 0; //todo aca cammbar si es as largo o no
    List<Token> tokens = findAndReplace(string, list, token, line, startPos, tokenStep, token.toString());
    return tokens;
  }
  
  private List<Token> findAndReplace(List<Token> tokens, TokenIdentifier token) {
    tokens = filterEmptyWIPToken(tokens);
    if (tokens.isEmpty()) return new ArrayList<>();
    final List<Token> answer = new ArrayList<>();
    for (Token t : tokens) {
      if (t.getName().equals(TokenName.WIP_TOKEN)) {
        final List<Token> andReplace = findAndReplace(t.getValue(), token, t.getLine(), t.getStartPos());
        answer.addAll(andReplace);
      } else {
        answer.add(t);
      }
    }
    return answer;
  }
  
  private Token stringToEmptyToken(String string, int line, int s, int e) {
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
  
  public void testing(String string, TokenIdentifier ti) {
    final Pattern regex = ti.getRegex();
    final Matcher matcher = regex.matcher(string);
    final ArrayList<String> objects = new ArrayList<>();
    while (matcher.find()) {
      objects.add(matcher.group());
    }
    System.out.println(
            "asd"
    );
  }
  
}