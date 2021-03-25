package edu.austral.ingsis;

public class LiteralSyntaxLeaf implements Operand {
  
  private final TokenWrapper literal;
  
  public LiteralSyntaxLeaf(TokenWrapper literal) {
    this.literal = literal;
  }
  
  @Override
  public void accept(Visitor visitor) {
    //todo implement
  }
}
