package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;

public class PrintCollector implements Printer {

  private final List<String> statements = new ArrayList<>();
  private boolean integerMode = false;

  @Override
  public void print(String message) {
    if (integerMode) {
      integerPrint(message);
    } else {
      statements.add(message);
    }
  }

  private void integerPrint(String string) {
    try {
      statements.add(Integer.toString((int) Double.parseDouble(string)));
    } catch (NumberFormatException ignored) {
      statements.add(string);
    }
  }

  @Override
  public void setIntegerMode() {
    integerMode = true;
  }

  public List<String> getStatements() {
    return statements;
  }
}

/*

  @Override
  public void print(String string) {
    if (integerMode) integerPrint(string);
    else System.out.println(string);
  }


*
* */
