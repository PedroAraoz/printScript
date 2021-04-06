package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.List;

public interface State {
  void setContext(CLI cli);
  List<String> run(String[] args) throws FileNotFoundException;
}
