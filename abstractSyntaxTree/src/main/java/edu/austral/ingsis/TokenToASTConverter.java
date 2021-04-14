package edu.austral.ingsis;

import edu.austral.ingsis.ASTCommand.*;
import java.util.HashMap;

public class TokenToASTConverter {

  final HashMap<TokenIdentifier, ASTCommand> map;

  public TokenToASTConverter() {

    this.map = new HashMap<>();

    this.map.put(TokenIdentifier.letTokenIdentifier, new EmptyCommand());
    this.map.put(TokenIdentifier.typeAssignationTokenIdentifier, new TypeAssignationCommand());
    this.map.put(TokenIdentifier.semicolonTokenIdentifier, new EmptyCommand());
    this.map.put(TokenIdentifier.valueAssignationTokenIdentifier, new ValueAssignationCommand());
    this.map.put(TokenIdentifier.sumOperationTokenIdentifier, new SumSubOperationCommand());
    this.map.put(TokenIdentifier.subOperationTokenIdentifier, new SumSubOperationCommand());
    this.map.put(TokenIdentifier.multOperationTokenIdentifier, new MultDivOperationCommand());
    this.map.put(TokenIdentifier.divOperationTokenIdentifier, new MultDivOperationCommand());
    this.map.put(TokenIdentifier.numberTypeTokenIdentifier, new NumberTypeCommand());
    this.map.put(TokenIdentifier.stringTypeTokenIdentifier, new StringTypeCommand());
    this.map.put(TokenIdentifier.numberLiteralTokenIdentifier, new LiteralCommand());
    this.map.put(TokenIdentifier.stringLiteralTokenIdentifier, new LiteralCommand());
    this.map.put(TokenIdentifier.variableTokenIdentifier, new VariableCommand());
  }

  public AbstractSyntaxTree convert(Token token) {
    final AbstractSyntaxTree tree = map.get(token.getToken()).build();
    tree.setTokenWrapper(token);
    return tree;
  }
}
