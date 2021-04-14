package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.io.FileNotFoundException;

public class App {
  public static void main(String[] args) {
    CLI cli = new CLI(new CLIPrinter());
    try {
      cli.run();
    } catch (FileNotFoundException | CompilationTimeException e) {
      e.printStackTrace();
    }
  }
}
// todo tenemos el bug que se come los espacios adentro de los string literals
