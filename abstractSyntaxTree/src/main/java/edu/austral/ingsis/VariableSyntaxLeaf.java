package edu.austral.ingsis;

public class VariableSyntaxLeaf implements DeclaVariable, Operand{

  private final TokenWrapper value;
  
  public VariableSyntaxLeaf(TokenWrapper value) {
    this.value = value;
  }
  
  public TokenWrapper getValue() {
    return value;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
