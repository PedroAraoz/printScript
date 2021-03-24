package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LexerImpl implements Lexer{
    private final TokenFactory tokenFactory = new TokenFactory();

    @Override
    public List<TokenWrapper> analyseLexically(CodeLine line) {
        final List<TokenWrapper> result = new ArrayList<>();
        final List<String> list = Arrays.asList(line.toString().split("(?!^)"));
        int startPos = 0;
        int endPos = 0;

        for (String c: list) {
            Optional<Token> tokenOptional = tokenFactory.put(c);
            endPos++;
            if (tokenOptional.isPresent()) {
                // Create TokenWrapper. Add extra information needed
                result.add(new TokenWrapper(tokenOptional.get(), line.getRow(), startPos, endPos, Optional.empty()));
                startPos = endPos;
            }
        }

        return result;
    }
}
