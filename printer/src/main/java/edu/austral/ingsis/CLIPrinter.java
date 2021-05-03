package edu.austral.ingsis;

public class CLIPrinter implements Printer {
  
  private boolean integerMode = false;
  
  @Override
  public void print(String string) {
    if (integerMode)
      integerPrint(string);
    else
      System.out.println(string);
  }
  
  private void integerPrint(String string) {
    try {
      System.out.println((int) Double.parseDouble(string));
    } catch (NumberFormatException ignored) {
      System.out.println(string);
    }
  }
  
  @Override
  public void setIntegerMode() {
    integerMode = true;
  }
}
