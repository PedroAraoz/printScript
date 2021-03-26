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
  
  //STATIC
  
  public static Token LET_TOKEN = new Token(TokenName.LET, TokenGroup.NOGROUP, Pattern.compile("let"));
  public static Token TYPE_ASSIGNATION_TOKEN = new Token(TokenName.TYPE_ASSIGNATION, TokenGroup.NOGROUP, Pattern.compile(":"));
  public static Token SEMICOLON_TOKEN = new Token(TokenName.SEMICOLON, TokenGroup.NOGROUP, Pattern.compile(";"));
  public static Token VALUE_ASSIGNATION_TOKEN = new Token(TokenName.VALUE_ASSIGNATION, TokenGroup.NOGROUP, Pattern.compile("="));
  public static Token SUM_OPERATION_TOKEN = new Token(TokenName.SUM, TokenGroup.OPERATION, Pattern.compile("\\+"));
  public static Token SUB_OPERATION_TOKEN = new Token(TokenName.SUB, TokenGroup.OPERATION, Pattern.compile("-"));
  public static Token MULT_OPERATION_TOKEN = new Token(TokenName.MULT, TokenGroup.OPERATION, Pattern.compile("\\*"));
  public static Token DIV_OPERATION_TOKEN = new Token(TokenName.DIV, TokenGroup.OPERATION, Pattern.compile("/"));
  public static Token NUMBER_TYPE_TOKEN = new Token(TokenName.NUMBER_TYPE, TokenGroup.TYPE, Pattern.compile("number"));
  public static Token STRING_TYPE_TOKEN = new Token(TokenName.STRING_TYPE, TokenGroup.TYPE, Pattern.compile("string"));
  public static Token LITERAL_TOKEN = new Token(TokenName.LITERAL, TokenGroup.NOGROUP, Pattern.compile("('[a-zA-Z]+')|(\"[a-zA-Z]+\")|[0-9]+|([0-9]+.[0-9]+)"));
  public static Token VARIABLE_TOKEN = new Token(TokenName.VARIABLE, TokenGroup.NOGROUP, Pattern.compile(""));
  
  public static List<Token> getAllTokens() {
    List<Token> tokens = new ArrayList<>();
    tokens.add(LET_TOKEN);
    tokens.add(TYPE_ASSIGNATION_TOKEN);
    tokens.add(SEMICOLON_TOKEN);
    tokens.add(VALUE_ASSIGNATION_TOKEN);
    tokens.add(SUM_OPERATION_TOKEN);
    tokens.add(SUB_OPERATION_TOKEN);
    tokens.add(MULT_OPERATION_TOKEN);
    tokens.add(DIV_OPERATION_TOKEN);
    tokens.add(NUMBER_TYPE_TOKEN);
    tokens.add(STRING_TYPE_TOKEN);
    return tokens;
  }
}
