package edu.austral.ingsis;

public class CodeLine {
  final private String string;
  final private int row;
  
  public CodeLine(String string, int row) {
    this.string = string;
    this.row = row;
  }
  
  public String toString(){
    return string;
  }
  public int getRow(){
    return row;
  }
}
