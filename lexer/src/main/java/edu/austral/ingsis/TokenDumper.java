package edu.austral.ingsis;

import java.util.Optional;
import java.util.Stack;

public class TokenDumper {
  private final Stack<Tuple> stack = new Stack<>();
  
  public void dump(Token token) {
    stack.push(new Tuple(token));
  }
  
  public void dumpVariable(Token token, String value) {
    stack.push(new Tuple(token, Optional.of(value)));
  }
  
  public boolean hasNext() {
    return stack.size() > 0;
  }
  
  public Tuple pop() {
    return stack.pop();
  }
}
