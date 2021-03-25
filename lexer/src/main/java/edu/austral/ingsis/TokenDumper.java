package edu.austral.ingsis;

import java.util.*;

public class TokenDumper {
  private final List<Tuple> list = new ArrayList<>();
  
  public void dump(Token token) {
    list.add(new Tuple(token));
  }
  
  public void dumpVariable(Token token, String value) {
    list.add(new Tuple(token, Optional.of(value)));
  }
  
  public boolean hasNext() {
    return list.size() > 0;
  }
  
  public Tuple pop() {
    final Tuple tuple = list.get(0);
    list.remove(0);
    return tuple;
  }
}
