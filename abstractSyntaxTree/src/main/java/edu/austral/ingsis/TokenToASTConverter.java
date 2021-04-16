package edu.austral.ingsis;

import edu.austral.ingsis.ASTCommand.*;
import java.util.HashMap;

public class TokenToASTConverter {

  final HashMap<TokenIdentifier, ASTCommand> map;// TODO ADD LOGIC OF VERSION 1.1

  public TokenToASTConverter() {

    this.map = new HashMap<>();

    this.map.put(TokenIdentifier.LET_TOKEN, new EmptyCommand());
    this.map.put(TokenIdentifier.TYPE_ASSIGNATION_TOKEN, new TypeAssignationCommand());
    this.map.put(TokenIdentifier.SEMICOLON_TOKEN, new EmptyCommand());
    this.map.put(TokenIdentifier.VALUE_ASSIGNATION_TOKEN, new ValueAssignationCommand());
    this.map.put(TokenIdentifier.SUM_OPERATION_TOKEN, new SumSubOperationCommand());
    this.map.put(TokenIdentifier.SUB_OPERATION_TOKEN, new SumSubOperationCommand());
    this.map.put(TokenIdentifier.MULT_OPERATION_TOKEN, new MultDivOperationCommand());
    this.map.put(TokenIdentifier.DIV_OPERATION_TOKEN, new MultDivOperationCommand());
    this.map.put(TokenIdentifier.NUMBER_TYPE_TOKEN, new NumberTypeCommand());
    this.map.put(TokenIdentifier.STRING_TYPE_TOKEN, new StringTypeCommand());
    this.map.put(TokenIdentifier.NUMBER_LITERAL_TOKEN, new LiteralCommand());
    this.map.put(TokenIdentifier.STRING_LITERAL_TOKEN, new LiteralCommand());
    this.map.put(TokenIdentifier.VARIABLE_TOKEN, new VariableCommand());
    this.map.put(TokenIdentifier.PRINTLN_TOKEN, new PrintLnCommand());
    this.map.put(TokenIdentifier.LEFT_PARENTHESIS_TOKEN, new LeftParenthesisCommand());
    this.map.put(TokenIdentifier.RIGHT_PARENTHESIS_TOKEN, new RightParenthesisCommand());
  }

  public AbstractSyntaxTree convert(Token token) {
    final AbstractSyntaxTree tree = map.get(token.getTokenIdentifier()).build();
    tree.setToken(token);
    return tree;
  }
}
