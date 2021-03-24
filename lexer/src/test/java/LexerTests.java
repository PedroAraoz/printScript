import edu.austral.ingsis.Token;
import edu.austral.ingsis.TokenFactory;
import org.junit.Test;

import java.util.Optional;

public class LexerTests {

    @Test
    public void tokenFactoryTest() {
        final TokenFactory tokenFactory = new TokenFactory();

        String[] test = {"l","e", "t"};

        for (String c : test) {
            Optional<Token> optional = tokenFactory.put(c);
            if (optional.isPresent()) {
                assert optional.get().equals("LET TOKEN");
            }
        }
    }
}
