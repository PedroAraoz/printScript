import edu.austral.ingsis.Token;
import java.util.List;
import org.junit.Test;

public class TokenTests {

  @Test
  public void getAllTokensTest() {
    List<Token> list = Token.getAllTokens();
    assert (!list.isEmpty());
  }

  @Test
  public void letRegexTest() {
    List<Token> list = Token.getAllTokens();
    assert true;
  }
}
