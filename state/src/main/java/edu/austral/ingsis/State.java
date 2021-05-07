package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.io.FileNotFoundException;

public interface State {
  void setContext(CLI cli);

  void run(String[] args) throws FileNotFoundException, CompilationTimeException;
}
