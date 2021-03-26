package edu.austral.ingsis;

public class AssignationSyntaxBranch implements AbstractSyntaxTree {
  
  private final DeclaVariable left;
  private final Operand right;
  private TokenWrapper token;
  
  public AssignationSyntaxBranch(DeclaVariable left, Operand right, TokenWrapper token) {
    this.left = left;
    this.right = right;
    this.token = token;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement.
  }
  
  public DeclaVariable getLeft() {
    return left;
  }
  
  public Operand getRight() {
    return right;
  }
  
  public TokenWrapper getToken() {
    return token;
  }
}
