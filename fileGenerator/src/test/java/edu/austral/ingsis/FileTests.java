package edu.austral.ingsis;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileTests {

  @Test
  public void FileConstructor_WithValidPath_HasNoExceptions() throws IOException {
    File f = new File("src/test/resources/test.txt");
  }

  @Test
  public void File_ShouldReturnContentInCodeLines() throws IOException {
    File f = new File("src/test/resources/test.txt");
    List<CodeLine> result = new ArrayList<>();
    List<CodeLine> expected = new ArrayList<>();
    expected.add(new CodeLine("Hello World!;", 0));
    expected.add(new CodeLine("Line 2 asd;", 1));
    while (f.hasNext()) {
      result.add(f.next().get());
    }
    for (int i = 0; i < result.size(); i++) {
      assertEquals(expected.get(i).toString(), result.get(i).toString());
      assertEquals(expected.get(i).getRow(), result.get(i).getRow());
    }
  }

  @Test
  public void NormalFileGeneratorShouldReturnFile() throws IOException {
    final String path = "src/test/resources/test.txt";
    final NormalFileGenerator normalFileGenerator = new NormalFileGenerator();
    final File generatedFile = normalFileGenerator.open(path);
    final File file = new File(path);
    while (file.hasNext()) {
      assertEquals(file.next().toString(), generatedFile.next().toString());
      assertEquals(file.next().get().getRow(), generatedFile.next().get().getRow());
    }
  }
}
