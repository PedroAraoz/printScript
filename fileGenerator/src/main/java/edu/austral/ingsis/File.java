package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;

public class File {
  final private List<CodeLine> codeLines;
  
  public File(List<CodeLine> codeLines) {
    this.codeLines = codeLines;
  }
  
  public List<CodeLine> getCodeLines() {
    return codeLines;
  }
  
  public CodeLine next() {
    return null;
  }
}
