package edu.austral.ingsis.fileGenerator;

import java.io.FileNotFoundException;

public class NormalFileGenerator implements FileGenerator {
  @Override
  public File open(String path) throws FileNotFoundException {
    return new File(path);
  }
}
