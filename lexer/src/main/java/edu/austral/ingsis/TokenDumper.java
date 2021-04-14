package edu.austral.ingsis;

import java.util.*;

public class TokenDumper {
  private final List<Tuple> list = new ArrayList<>();

  public void dump(TokenIdentifier tokenIdentifier, String value) {
    list.add(new Tuple(tokenIdentifier, value));
  }

  public boolean hasNext() {
    return list.size() > 0;
  }

  public Tuple pop() {
    return list.remove(0);
  }
}
