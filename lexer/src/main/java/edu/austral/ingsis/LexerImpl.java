package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LexerImpl implements OurLexer {

  private List<OurToken> tokens = new ArrayList<>();
  private String version = "1.0";

  @Override
  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public void analyseLexically(List<String> code) {
    List<OurToken> tokens = new ArrayList<>();
    List<TokenIdentifier> one = TokenIdentifier.getPriorityOneTokens(version);
    List<TokenIdentifier> two = TokenIdentifier.getPriorityTwoTokens();
    List<TokenIdentifier> all = TokenIdentifier.getAllTokens(version);
    // PART 1 we split based on the no-space tokens (priorityOne)
    for (int i = 0; i < code.size(); i++) tokens.add(stringToEmptyToken(code.get(i), i, 0, 0));
    for (TokenIdentifier ti : one) tokens = findAndSplit(tokens, ti);

    // then we remove unnecessary spaces that might be there.
    doubleTrim(tokens);
    tokens = fixString(tokens, code);
    findAndReplace(tokens, two);
    tokens = removeSpacesInWIPToken(tokens);
    tokens = filterEmptyWIPToken(tokens);
    // then we find and replace the tokens in an important order.
    findAndReplace(tokens, all);
    removeQuotationMarkers(tokens);
    this.tokens = tokens;
  }

  private List<OurToken> fixString(List<OurToken> tokens, List<String> code) {
    final List<OurToken> answer = new ArrayList<>();
    String acc = "";
    boolean unClosed = false;
    int startPos = 0;
    for (int i = 0; i < tokens.size(); i++) {
      OurToken token = tokens.get(i);
      if (containsQuotations(token.getValue())) {
        if (!unClosed) {
          unClosed = true;
          acc = token.getValue();
          startPos = token.getStartPos();
        } else {
          unClosed = false;
          acc += token.getValue();
          //          acc = acc.replace("  ", " ").trim();
          answer.add(stringToEmptyToken(acc, token.getLine(), startPos, startPos + acc.length()));
        }
      } else if (unClosed) {
        token = fixKeywords(token, code);
        acc += token.getValue();
      } else {
        answer.add(token);
      }
    }
    return answer;
  }

  private OurToken fixKeywords(OurToken token, List<String> code) {
    String value = token.getValue();
    int endPos = token.getEndPos();
    List<TokenIdentifier> one = TokenIdentifier.getPriorityOneTokens(version);
    for (TokenIdentifier ti : one) {
      if (ti.verify(value)) {
        final List<String> l = Arrays.asList(code.get(token.getLine()).split(value));
        for (int i = 0; i < l.size() - 1; i++) {
          String s = l.get(i);
          if (s.contains("\"") || s.contains("\'")) {
            value += (l.get(i + 1).charAt(0) == ' ') ? " " : "";
          }
        }
        endPos++;
        break;
      }
    }
    return new OurToken(
        token.getTokenIdentifier(), token.getLine(), token.getStartPos(), endPos, value);
  }

  private boolean containsQuotations(String value) {
    final int length = value.length();
    final String replace1 = value.replace("\"", "");
    final String replace2 = value.replace("'", "");
    return length - replace1.length() == 1 || length - replace2.length() == 1;
  }

  public List<OurToken> findAndSplit(List<OurToken> tokens, TokenIdentifier ti) {
    List<OurToken> list = new ArrayList<>();
    for (int i = 0; i < tokens.size(); i++) {
      final OurToken t = tokens.get(i);
      final String value = t.getValue();
      if (!specificCase(ti, value)) {
        final Pattern pattern = addLookaheadandLookbehind(ti.getRegex());
        final String[] split = pattern.split(value);
        int startpos = 0;
        for (String s : split) {
          int endpos = startpos + s.length() - 1;
          final OurToken token =
              stringToEmptyToken(
                  s, t.getLine(), t.getStartPos() + startpos, t.getEndPos() + endpos);
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
    return ((ti.getName().equals(TokenName.VALUE_ASSIGNATION)
            || ti.getName().equals(TokenName.GREATER)
            || ti.getName().equals(TokenName.LESSER))
        && (value.contains("<=") || value.contains(">=")));
  }

  public Pattern addLookaheadandLookbehind(Pattern p) {
    String regex = p.pattern();
    regex = "((?<=" + regex + ")|(?=" + regex + "))";
    return Pattern.compile(regex);
  }

  private void findAndReplace(List<OurToken> tokens, List<TokenIdentifier> two) {
    for (TokenIdentifier ti : two) {
      for (int i = 0; i < tokens.size(); i++) {
        OurToken t = tokens.get(i);
        if (t.getName().equals(TokenName.WIP_TOKEN)) {
          if (ti.verify(t.getValue())) {
            tokens.set(
                i, new OurToken(ti, t.getLine(), t.getStartPos(), t.getEndPos(), t.getValue()));
          }
        }
      }
    }
  }

  private void doubleTrim(List<OurToken> tokens) {
    for (int i = 0; i < tokens.size(); i++) {
      final OurToken t = tokens.get(i);
      if (t.getName().equals(TokenName.WIP_TOKEN)) {
        int originalSize = t.getValue().length();
        String trimmed = t.getValue().trim();
        int deltaStart = trimmed.length() - originalSize;
        final String reversed = new StringBuilder(trimmed).reverse().toString();
        int originalReversedSize = reversed.length();
        String reverseTrimmed = reversed.trim();
        int deltaEnd = reverseTrimmed.length() - originalReversedSize;
        final String finalString = new StringBuilder(reverseTrimmed).reverse().toString();
        OurToken token =
            stringToEmptyToken(
                finalString, t.getLine(), t.getStartPos() + deltaStart, t.getEndPos() - deltaEnd);
        tokens.set(i, token);
      }
    }
  }

  private List<OurToken> removeSpacesInWIPToken(List<OurToken> tokens) {
    final List<OurToken> answer = new ArrayList<>();
    for (OurToken t : tokens) {
      if (t.getName().equals(TokenName.WIP_TOKEN)) {
        final List<String> strings = Arrays.asList(t.getValue().split(" "));
        int startPos = t.getStartPos();
        int endPos;
        for (String s : strings) {
          endPos = startPos + s.length();
          answer.add(stringToEmptyToken(s, t.getLine(), startPos, endPos));
          startPos = endPos + 1;
        }
      } else {
        answer.add(t);
      }
    }
    return answer;
  }

  private void removeQuotationMarkers(List<OurToken> tokens) {
    for (OurToken t : tokens) {
      if (t.getName().equals(TokenName.STRING_LITERAL)) {
        t.setValue(t.getValue().substring(1, t.getValue().length() - 1));
        t.setStartPos(t.getStartPos() + 1);
        t.setEndPos(t.getEndPos() - 1);
      }
    }
  }

  private List<OurToken> filterEmptyWIPToken(List<OurToken> tokens) {
    return tokens.stream().filter(e -> !e.getValue().equals("")).collect(Collectors.toList());
  }

  public OurToken stringToEmptyToken(String string, int line, int s, int e) {
    return new OurToken(TokenIdentifier.WIP_TOKEN, line, s, e, string);
  }

  @Override
  public Optional<OurToken> getNextToken() {
    try {
      return Optional.ofNullable(tokens.remove(0));
    } catch (IndexOutOfBoundsException _ignored) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<OurToken> peek() {
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
  public List<OurToken> getAll() {
    return tokens;
  }
}
