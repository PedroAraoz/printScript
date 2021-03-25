import edu.austral.ingsis.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LexerTests {

//  @Test
//  public void tokenFactoryTest() {
//    final TokenFactory tokenFactory = new TokenFactory();
//
//    String[] test = {"l","e", "t"};
//
//    for (String c : test) {
//      Optional<Token> optional = tokenFactory.put(c);
//      if (optional.isPresent()) {
//        assert optional.get().equals("LET TOKEN");
//      }
//    }
//  }
//
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
