package edu.austral.ingsis;

import java.util.regex.Pattern;

public class Token {
  private final TokenIdentifier tokenIdentifier;
  private final int line;
  private int startPos;
  private int endPos;
  private String value;
  
  public Token(TokenIdentifier tokenIdentifier, int line, int startPos, int endPos, String value) {
    this.tokenIdentifier = tokenIdentifier;
    this.line = line;
    this.startPos = startPos;
    this.endPos = endPos;
    this.value = value;
  }
  
  public TokenName getName() {
    return tokenIdentifier.getName();
  }
  
  public String toString() {
    return tokenIdentifier.toString();
  }
  
  public Pattern getRegex() {
    return tokenIdentifier.getRegex();
  }
  
  public boolean verify(String s) {
    return tokenIdentifier.verify(s);
  }
  
  public int getLine() {
    return line;
  }
  
  public int getStartPos() {
    return startPos;
  }
  
  public int getEndPos() {
    return endPos;
  }
  
  public String getValue() {
    return value;
  }
  
  public TokenIdentifier getTokenIdentifier() {
    return tokenIdentifier;
  }
  
  public void setValue(String value) {
    this.value = value;
  }
  
  public void setStartPos(int startPos) {
    this.startPos = startPos;
  }
  
  public void setEndPos(int endPos) {
    this.endPos = endPos;
  }
}
