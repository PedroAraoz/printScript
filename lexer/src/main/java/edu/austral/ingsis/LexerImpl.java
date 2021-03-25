package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LexerImpl implements Lexer {
    private final TokenDumper dumper = new TokenDumper();
    private final TokenFactory tokenFactory = new TokenFactory(dumper);

    @Override
    public List<TokenWrapper> analyseLexically(CodeLine line) {
        final List<TokenWrapper> result = new ArrayList<>();
        final List<String> list = Arrays.asList(line.toString().split("(?!^)"));
        int startPos = 0;
        int endPos = 0;

        for (String c: list) {
            tokenFactory.put(c);
            endPos++;
            while (dumper.hasNext()) {
                // Create TokenWrapper. Add extra information needed
                final Tuple t = dumper.pop();
                result.add(new TokenWrapper(t.getToken(), line.getRow(), startPos, endPos, t.getOptional()));
                startPos = endPos;
            }
        }

        return result;
    }
}
