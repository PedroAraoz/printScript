package edu.austral.ingsis;

public class OperationSyntaxBranch implements Operand {
  
  private final Operand left, right;
  private final OperatorToken operator;
  
  public OperationSyntaxBranch(Operand left, Operand right, OperatorToken operator) {
    this.left = left;
    this.right = right;
    this.operator = operator;
  }
  
  @Override
  public Token getToken() {
    return null;
  }
  
  @Override
  public Literal calculate() {
    return operator(left.calculate(), right.calculate());
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
