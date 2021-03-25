package edu.austral.ingsis;

public class AssignationSyntaxBranch implements AbstractSyntaxTree {
  
  private final DeclaVariable declaVariable;
  private final Operand operand;
  private TokenWrapper token;
  
  public AssignationSyntaxBranch(DeclaVariable declaVariable, Operand operand, TokenWrapper token) {
    this.declaVariable = declaVariable;
    this.operand = operand;
    this.token = token;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement.
  }
}
