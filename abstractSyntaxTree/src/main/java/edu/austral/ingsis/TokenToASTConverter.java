package edu.austral.ingsis;

import edu.austral.ingsis.ASTCommand.*;

import java.util.HashMap;

public class TokenToASTConverter {

  final HashMap<Token, ASTCommand> map;

  public TokenToASTConverter() {

    this.map = new HashMap<>();

    this.map.put(Token.LET_TOKEN, new EmptyCommand());
    this.map.put(Token.TYPE_ASSIGNATION_TOKEN, new TypeAssignationCommand());
    this.map.put(Token.SEMICOLON_TOKEN, new EmptyCommand());
    this.map.put(Token.VALUE_ASSIGNATION_TOKEN, new ValueAssignationCommand());
    this.map.put(Token.SUM_OPERATION_TOKEN, new SumSubOperationCommand());
    this.map.put(Token.SUB_OPERATION_TOKEN, new SumSubOperationCommand());
    this.map.put(Token.MULT_OPERATION_TOKEN, new MultDivOperationCommand());
    this.map.put(Token.DIV_OPERATION_TOKEN, new MultDivOperationCommand());
    this.map.put(Token.NUMBER_TYPE_TOKEN, new NumberTypeCommand());
    this.map.put(Token.STRING_TYPE_TOKEN, new StringTypeCommand());
    this.map.put(Token.LITERAL_TOKEN, new LiteralCommand());
    this.map.put(Token.VARIABLE_TOKEN, new VariableCommand());
  }

  public AbstractSyntaxTree convert(TokenWrapper tokenWrapper) {
    final AbstractSyntaxTree tree = map.get(tokenWrapper.getToken()).build();
    tree.setTokenWrapper(tokenWrapper);
    return tree;
  }
}
