package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Token {
  private final TokenName name;
  private final TokenGroup group;
  private final Pattern regex;
  
  public Token(TokenName name, TokenGroup group, Pattern regex) {
    this.name = name;
    this.group = group;
    this.regex = regex;
  }
  
  public TokenName getName() {
    return name;
  }
  
  public TokenGroup getGroup() {
    return group;
  }
  
  public Pattern getRegex() {
    return regex;
  }
  
  public String toString() {
    return name.toString();
  }
  
  public boolean verify(String s) {
    return regex.matcher(s).matches();
  }
  
  public static List<Token> getAllTokens() {
    List<Token> tokens = new ArrayList<>();
    
    //TODO cosas para despues: a los espacios en las regex agregar tabs o intros
    
    tokens.add(new Token(TokenName.LET, TokenGroup.NOGROUP, Pattern.compile("let ")));
    tokens.add(new Token(TokenName.TYPE_ASSIGNATION, TokenGroup.NOGROUP, Pattern.compile("( *)+:")));
    tokens.add(new Token(TokenName.SEMICOLON, TokenGroup.NOGROUP, Pattern.compile("( *)+;")));
    tokens.add(new Token(TokenName.VALUE_ASSIGNATION, TokenGroup.NOGROUP, Pattern.compile("( *)+=")));
    tokens.add(new Token(TokenName.SUM, TokenGroup.OPERATION, Pattern.compile("( *)+\\+")));
    tokens.add(new Token(TokenName.SUB, TokenGroup.OPERATION, Pattern.compile("( *)+-")));
    tokens.add(new Token(TokenName.MULT, TokenGroup.OPERATION, Pattern.compile("( *)+\\*")));
    tokens.add(new Token(TokenName.DIV, TokenGroup.OPERATION, Pattern.compile("( *)+/")));
    tokens.add(new Token(TokenName.NUMBER_TYPE, TokenGroup.TYPE, Pattern.compile("( +)+number")));
    tokens.add(new Token(TokenName.STRING_TYPE, TokenGroup.TYPE, Pattern.compile("( +)+string")));
    tokens.add(new Token(TokenName.LITERAL, TokenGroup.NOGROUP, Pattern.compile("( *)(('[a-zA-Z]+')|(\"[a-zA-Z]+\")|[0-9]+( )|[0-9]+.+[0-9]+( ))")));
    tokens.add(new Token(TokenName.VARIABLE, TokenGroup.NOGROUP, Pattern.compile("[a-zA-Z]+( +)")));
    
    return tokens;
  }
}
