package edu.austral.ingsis;

public class DeclarationSyntaxLeaf implements DeclaVariable{
  
  private final TokenWrapper type, variable;
  
  public DeclarationSyntaxLeaf(TokenWrapper type, TokenWrapper variable) {
    this.type = type;
    this.variable = variable;
  }
  
  public TokenWrapper getVariable() {
    return variable;
  }
  
  public TokenWrapper getType() {
    return type;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
