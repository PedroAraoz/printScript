package edu.austral.ingsis;

public class VariableSyntaxLeaf implements DeclaVariable, Operand{
  
  private final String name;
  private final Literal value;
  
  public VariableSyntaxLeaf(String name, Literal value) {
    this.name = name;
    this.value = value;
  }
  
  public String getName() {
    return name;
  }
  
  public Literal getValue() {
    return value;
  }
  
  @Override
  public Token getToken() {
    //todo implement
  }
  
  @Override
  public Literal calculate() {
    //todo implement
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
