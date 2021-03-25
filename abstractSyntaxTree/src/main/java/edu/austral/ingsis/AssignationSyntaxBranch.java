package edu.austral.ingsis;

public class AssignationSyntaxBranch implements AbstractSyntaxTree {
  
  private final DeclaVariable declaVariable;
  private final Operand operand;
  private Token token;
  
  public AssignationSyntaxBranch(DeclaVariable declaVariable, Operand operand, Token token) {
    this.declaVariable = declaVariable;
    this.operand = operand;
    this.token = token;
  }
  
  @Override
  public Token getToken() {
    return token;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement.
  }
}
