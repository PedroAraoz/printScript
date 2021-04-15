package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class File {

  //todo checkear que las sentencias las calcule bien.!

  private final String endCharacter = ";";
  private final Scanner scanner;
  private int count = 0;
  private String buffer = "";
  private int lines;

  public File(String path) throws FileNotFoundException {
    calculateLines(path);
    final java.io.File file = new java.io.File(path);
    scanner = new Scanner(file);
  }

  private void calculateLines(String path) throws FileNotFoundException {
    java.io.File f = new java.io.File(path);
    Scanner s = new Scanner(f);
//    lines = (int) s.findAll(endCharacter).count() - 1;
    lines = 10;
    s.close();
  }

  public boolean hasNext() {
    if (scanner.hasNext()) return true;
    scanner.close();
    return false;
  }

  public Optional<CodeLine> next() {
    buffer += scanner.nextLine();
    if (buffer.contains(endCharacter)) {
      final String[] split = buffer.split(endCharacter);
      final CodeLine codeLine = new CodeLine(split[0].replaceAll("(\n)+", " ") + endCharacter, count);
      count++;
      buffer = buffer.substring(split[0].length() + 1);
      return Optional.of(codeLine);
    } else if (hasNext()) {
      buffer += "\n";
      return next();
    }
    return Optional.empty();
  }

  public int getLines() {
    return lines;
  }
}
