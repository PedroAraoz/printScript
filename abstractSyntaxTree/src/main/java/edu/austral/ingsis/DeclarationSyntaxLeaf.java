package edu.austral.ingsis;

public class DeclarationSyntaxLeaf implements DeclaVariable{
  
  private final TypeToken type;
  private final VariableToken variable;
  
  public DeclarationSyntaxLeaf(TypeToken type, VariableToken variable) {
    this.type = type;
    this.variable = variable;
  }
  
  public VariableToken getVariable() {
    return variable;
  }
  
  public TypeToken getType() {
    return type;
  }
  
  @Override
  public Token getToken() {
    return null;//todo implement
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
