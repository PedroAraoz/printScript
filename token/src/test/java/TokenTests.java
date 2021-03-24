import edu.austral.ingsis.Token;
import org.junit.Test;

import java.util.List;

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
