package edu.austral.ingsis.fileGenerator;

import java.io.FileNotFoundException;

public interface FileGenerator {
  File open(String path) throws FileNotFoundException;
}
