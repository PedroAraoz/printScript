package edu.austral.ingsis;

public class LiteralSyntaxLeaf implements Operand {
  
  private final LiteralToken literal;
  
  public LiteralSyntaxLeaf(LiteralToken literal) {
    this.literal = literal;
  }
  
  @Override
  public Token getToken() {
    //todo implement
    return null;
  }
  
  @Override
  public Literal calculate() {
    return literal?;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
