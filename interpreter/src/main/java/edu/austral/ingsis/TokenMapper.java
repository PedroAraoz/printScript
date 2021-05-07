package edu.austral.ingsis;

import edu.austral.ingsis.ASTCommand.*;
import java.util.HashMap;

public class TokenMapper {

  final HashMap<TokenType, TokenIdentifier> map;

  public TokenMapper() {

    this.map = new HashMap<>();

    this.map.put(KeyWord.DECLARATION, TokenIdentifier.LET_TOKEN);
    this.map.put(KeyWord.VARIABLE_REF, TokenIdentifier.VARIABLE_TOKEN);
    this.map.put(Operator.T_ASSIGNATION, TokenIdentifier.TYPE_ASSIGNATION_TOKEN);
    this.map.put(Operator.SEMICOLONS, TokenIdentifier.SEMICOLON_TOKEN);
    this.map.put(Operator.EQUAL, TokenIdentifier.VALUE_ASSIGNATION_TOKEN);
    this.map.put(Operator.PLUS, TokenIdentifier.SUM_OPERATION_TOKEN);
    this.map.put(Operator.HYPHEN, TokenIdentifier.SUB_OPERATION_TOKEN);
    this.map.put(Operator.ASTERISK, TokenIdentifier.MULT_OPERATION_TOKEN);
    this.map.put(Operator.DASH, TokenIdentifier.DIV_OPERATION_TOKEN);
    this.map.put(KeyWord.N_ASSIGNATION, TokenIdentifier.NUMBER_TYPE_TOKEN);
    this.map.put(KeyWord.S_ASSIGNATION, TokenIdentifier.STRING_TYPE_TOKEN);
    this.map.put(KeyWord.NUMBER, TokenIdentifier.NUMBER_LITERAL_TOKEN);
    this.map.put(KeyWord.STRING, TokenIdentifier.STRING_LITERAL_TOKEN);
    this.map.put(KeyWord.PRINTLN, TokenIdentifier.PRINTLN_TOKEN);
    this.map.put(Operator.L_PARENTHESIS, TokenIdentifier.LEFT_PARENTHESIS_TOKEN);
    this.map.put(Operator.R_PARENTHESIS, TokenIdentifier.RIGHT_PARENTHESIS_TOKEN);
    this.map.put(KeyWord.B_ASSIGNATION, TokenIdentifier.BOOLEAN_TYPE_TOKEN);
    this.map.put(KeyWord.C_DECLARATION, TokenIdentifier.CONST_TOKEN);
    this.map.put(KeyWord.IF_STATEMENT, TokenIdentifier.IF_TOKEN);
    this.map.put(Operator.GREATER, TokenIdentifier.GREATER_TOKEN);
    this.map.put(Operator.MINOR, TokenIdentifier.LESSER_TOKEN);
    this.map.put(Operator.GREATER_EQUAL, TokenIdentifier.GREATER_EQUALS_TOKEN);
    this.map.put(Operator.MINOR_EQUAL, TokenIdentifier.LESSER_EQUALS_TOKEN);
    this.map.put(KeyWord.BOOLEAN, TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    this.map.put(Operator.L_KEY, TokenIdentifier.LEFT_BRACKET_TOKEN);
    this.map.put(Operator.R_KEY, TokenIdentifier.RIGHT_BRACKET_TOKEN);
    this.map.put(KeyWord.ELSE_STATEMENT, TokenIdentifier.ELSE_TOKEN);
  }

  public OurToken convert(Token token) {

    TokenIdentifier tokenIdentifier = map.get(token.getType());
    return new OurToken(
        tokenIdentifier,
        token.getPosition().getRow(),
        token.getPosition().getColumn(),
        token.getPosition().getColumn(),
        token.getValue());
  }
}
