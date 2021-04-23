package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;

public class PrintCollector implements Printer {

  private final List<String> statements = new ArrayList<>();

  @Override
  public void print(String message) {
    statements.add(message);
  }

  public List<String> getStatements() {
    return statements;
  }
}
