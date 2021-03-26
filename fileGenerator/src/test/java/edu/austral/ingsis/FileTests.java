package edu.austral.ingsis;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileTests {
  
  @Test
  public void FileConstructor_WithValidPath_HasNoExceptions() throws IOException {
    File f = new File("src/test/resources/test.txt");
  }
  
  @Test
  public void File_ShouldReturnContentInCodeLines() throws FileNotFoundException {
    File f = new File("src/test/resources/test.txt");
    List<CodeLine> result = new ArrayList<>();
    List<CodeLine> expected = new ArrayList<>();
    expected.add(new CodeLine("Hello World!", 0));
    expected.add(new CodeLine("Line 2", 1));
    expected.add(new CodeLine("", 2));
    expected.add(new CodeLine("asd", 3));
    while (f.hasNext()) {
      result.add(f.next());
    }
    for (int i = 0; i < result.size(); i++) {
      assertEquals(result.get(i).toString(), expected.get(i).toString());
      assertEquals(result.get(i).getRow(), expected.get(i).getRow());
    }
  }
  
  @Test
  public void NormalFileGeneratorShouldReturnFile() throws FileNotFoundException {
    final String path = "src/test/resources/test.txt";
    final NormalFileGenerator normalFileGenerator = new NormalFileGenerator();
    final File generatedFile = normalFileGenerator.open(path);
    final File file = new File(path);
    while (file.hasNext()) {
      assertEquals(file.next().toString(), generatedFile.next().toString());
      assertEquals(file.next().getRow(), generatedFile.next().getRow());
    }
  }
}
