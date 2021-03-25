import edu.austral.ingsis.CodeLine;
import edu.austral.ingsis.File;
import edu.austral.ingsis.LexerImpl;
import edu.austral.ingsis.TokenWrapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LexerTests {

  @Test
  public void asdasdasd() {
    List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("let x: number = 2 + 3", 0));
    File file = new File(codeLineList);
    LexerImpl lexer = new LexerImpl();
    final List<TokenWrapper> tokenWrappers = lexer.analyseLexically(file.getCodeLines().get(0));
    System.out.println("asd");
  }
}
