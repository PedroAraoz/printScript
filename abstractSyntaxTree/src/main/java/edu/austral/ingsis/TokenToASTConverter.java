package edu.austral.ingsis;

import java.util.HashMap;

public class TokenToASTConverter {

  final HashMap<Token, AbstractSyntaxTree> map;

  public TokenToASTConverter() {

    this.map = new HashMap<>();

    this.map.put(Token.LET_TOKEN, new EmptySyntaxLeaf());
    this.map.put(Token.TYPE_ASSIGNATION_TOKEN, new TypeAssignationSyntaxBranch());
    this.map.put(Token.SEMICOLON_TOKEN, new EmptySyntaxLeaf());
    this.map.put(Token.VALUE_ASSIGNATION_TOKEN, new ValueAssignationSyntaxBranch());
    this.map.put(Token.SUM_OPERATION_TOKEN, new SumSubOperationSyntaxBranch());
    this.map.put(Token.SUB_OPERATION_TOKEN, new SumSubOperationSyntaxBranch());
    this.map.put(Token.MULT_OPERATION_TOKEN, new MultDivOperationSyntaxBranch());
    this.map.put(Token.DIV_OPERATION_TOKEN, new MultDivOperationSyntaxBranch());
    this.map.put(Token.NUMBER_TYPE_TOKEN, new NumberTypeSyntaxLeaf());
    this.map.put(Token.STRING_TYPE_TOKEN, new StringTypeSyntaxLeaf());
    this.map.put(Token.LITERAL_TOKEN, new LiteralSyntaxLeaf());
    this.map.put(Token.VARIABLE_TOKEN, new VariableSyntaxLeaf());
  }

  public AbstractSyntaxTree convert(TokenWrapper tokenWrapper) {
    final AbstractSyntaxTree tree = map.get(tokenWrapper.getToken());
    tree.setTokenWrapper(tokenWrapper);
    return tree;
  }
}
