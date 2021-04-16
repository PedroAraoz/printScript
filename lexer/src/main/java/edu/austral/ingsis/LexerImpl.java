package edu.austral.ingsis;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class LexerImpl implements Lexer {
  
  public List<Token> analyseLexically(List<String> code) {
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
    for (TokenIdentifier i : two) {
      tokens = findAndReplaceTwo(tokens, i);
    }
    return tokens;
  }
  
  private List<Token> findAndReplaceTwo(List<Token> tokens, TokenIdentifier ti) {
    final List<Token> answer = new ArrayList<>();
    for (Token t : tokens) {
      if (t.getName().equals(TokenName.WIP_TOKEN)) {
        final String string = t.getValue();
        final Matcher matcher = ti.getRegex().matcher(string);
        List<String> matches = matcher.results().map(MatchResult::group).collect(Collectors.toList());
        for (String s : matches) {
          final List<String> strings = Arrays.asList(string.split(s));
          int startPos = t.getStartPos();
          int endPos;
          for (int i = 0; i < strings.size() - 1; i++) {
            endPos = startPos + strings.get(i)
            answer.add(stringToEmptyToken(strings.get(i), t.getLine(), startPos, ))
          }
        }
        
        
      } else {
        answer.add(t);
      }
    }
    return answer;
  }
  
  
  private void wat(String string, List<String> list, TokenIdentifier token, int line, int startPos) {
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
      endPos++;
      tokens.add(new Token(token, line, endPos, endPos, token.toString()));
      startPos = endPos + 1;
    }
    endPos = startPos + list.get(list.size() - 1).length() - 1;
    tokens.add(stringToEmptyToken(list.get(list.size() - 1), line, startPos, endPos));
    startPos = endPos + 1;
    if (token.verify(string.substring(string.length() - 2)) || token.verify(string.substring(string.length() - 1))) {
      //si el ultimo o ultimos 2 caracters del string matchea es porque falta un ultimo
      tokens.add(new Token(token, line, startPos, startPos, token.toString()));
    }
  }
  
  private List<Token> filterEmptyWIPToken(List<Token> tokens) {
    return tokens.stream().filter(e -> !e.getValue().equals("")).collect(Collectors.toList());
  }
  
  public List<Token> findAndReplace(String string, TokenIdentifier token, int line) {
    return findAndReplace(string, token, line, 0);
  }
  
  public List<Token> findAndReplace(String string, TokenIdentifier token, int line, int startPos) {
    final List<String> list = Arrays.asList(token.getRegex().split(string));
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
      endPos++;
      tokens.add(new Token(token, line, endPos, endPos, token.toString()));
      startPos = endPos + 1;
    }
    endPos = startPos + list.get(list.size() - 1).length() - 1;
    tokens.add(stringToEmptyToken(list.get(list.size() - 1), line, startPos, endPos));
    startPos = endPos + 1;
    if (token.verify(string.substring(string.length() - 2)) || token.verify(string.substring(string.length() - 1))) {
      //si el ultimo o ultimos 2 caracters del string matchea es porque falta un ultimo
      tokens.add(new Token(token, line, startPos, startPos, token.toString()));
    }
    return tokens;
  }
  
  public List<Token> findAndReplace(List<Token> tokens, TokenIdentifier token) {
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
  
  @Override
  public List<Token> analyseLexically(CodeLine line) {
    return Collections.singletonList(new Token(TokenIdentifier.WIP_TOKEN, 0, 0, 0, ""));
  }
  
  
  public Optional<Token> getNextToken() {
    return null;
  }
}
//todo cuando metes en step 1 characters de 2 de largo se rompen las locations