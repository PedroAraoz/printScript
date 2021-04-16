package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class File {
  
  private final Scanner scanner;
  public File(String path) throws FileNotFoundException {
    final java.io.File file = new java.io.File(path);
    scanner = new Scanner(file);
  }
  public boolean hasNext() {
    if (scanner.hasNext()) return true;
    scanner.close();
    return false;
  }

  public String next() {
    return scanner.nextLine();
  }
}
