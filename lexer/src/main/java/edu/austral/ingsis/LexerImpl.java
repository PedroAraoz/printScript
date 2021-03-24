package edu.austral.ingsis;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LexerImpl implements Lexer{
    private final TokenFactory tokenFactory = new TokenFactory();

    @Override
    public List<TokenWrapper> analyseLexically(String line) {
        final List<String> list = Arrays.asList(line.split("(?!^)"));
        for (String c: list) {
            Optional<Token> tokenOptional = tokenFactory.put(c);
            if (tokenOptional.isPresent()) {
                // Create TokenWrapper. Will need Col position (index of loop) and Row position (idk)
            }
        }
        return null;
    }
}
