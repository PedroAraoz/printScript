import edu.austral.ingsis.CLI;
import edu.austral.ingsis.CLIPrinter;
import edu.austral.ingsis.exception.CompilationTimeException;
import java.io.FileNotFoundException;
import org.junit.Test;

public class CLITests {

  @Test
  public void testCLIRawRunExecuterOutputFalse()
      throws FileNotFoundException, CompilationTimeException {
    CLI cli = new CLI(new CLIPrinter());
    cli.run("execute src/test/resources/test.txt 1.1 output-enabled=false");
  }

  @Test
  public void testCLIRawRunValidatorOutputFalse()
      throws FileNotFoundException, CompilationTimeException {
    CLI cli = new CLI(new CLIPrinter());
    cli.run("validate src/test/resources/test.txt 1.1 output-enabled=false");
  }

  @Test
  public void testCLIRawRunExecuterOutputTrue()
      throws FileNotFoundException, CompilationTimeException {
    CLI cli = new CLI(new CLIPrinter());
    cli.run("execute src/test/resources/test.txt 1.1 output-enabled=true");
  }

  @Test
  public void testCLIRawRunValidatorOutputTrue()
      throws FileNotFoundException, CompilationTimeException {
    CLI cli = new CLI(new CLIPrinter());
    cli.run("validate src/test/resources/test.txt 1.1 output-enabled=true");
  }
}
