package edu.austral.ingsis;

public class CodeLine {
  private final String string;
  private final int row;

  public CodeLine(String string, int row) {
    this.string = string;
    this.row = row;
  }

  public String toString() {
    return string;
  }

  public int getRow() {
    return row;
  }
}
