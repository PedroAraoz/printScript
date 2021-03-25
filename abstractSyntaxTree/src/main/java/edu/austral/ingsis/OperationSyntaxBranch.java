package edu.austral.ingsis;

public class OperationSyntaxBranch implements Operand {
  
  private final Operand left, right;
  private final TokenWrapper operator;
  
  public OperationSyntaxBranch(Operand left, Operand right, TokenWrapper operator) {
    this.left = left;
    this.right = right;
    this.operator = operator;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
