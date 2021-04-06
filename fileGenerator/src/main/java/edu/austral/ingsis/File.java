package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File {
  
  //todo cambiar file para que levante de a 1 linea a la vez en vez de que levante
  //todo a memoria. Tambien hacer que sean sentencias en vez de lineas.
  private final List<CodeLine> codeLines = new ArrayList<>();

  public File(String path) throws FileNotFoundException {

    java.io.File file = new java.io.File(path);
    Scanner scanner = new Scanner(file);
    int count = 0;
    while (scanner.hasNextLine()) {
      String data = scanner.nextLine();
      codeLines.add(new CodeLine(data, count));
      count++;
    }
    scanner.close();
  }

  public boolean hasNext() {
    return codeLines.size() > 0;
  }

  public CodeLine next() {
    return codeLines.remove(0);
  }
}
