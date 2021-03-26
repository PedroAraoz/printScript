package edu.austral.ingsis;

import java.io.FileNotFoundException;

public interface FileGenerator {
  File open(String path) throws FileNotFoundException;
}
