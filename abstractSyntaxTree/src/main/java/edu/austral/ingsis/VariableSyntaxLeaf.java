package edu.austral.ingsis;

public class VariableSyntaxLeaf implements DeclaVariable, Operand{
  
  private final String name;
  private final TokenWrapper value;
  
  public VariableSyntaxLeaf(String name, TokenWrapper value) {
    this.name = name;
    this.value = value;
  }
  
  public String getName() {
    return name;
  }
  
  public TokenWrapper getValue() {
    return value;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
