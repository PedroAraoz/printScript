package edu.austral.ingsis;

import java.util.Optional;
import java.util.regex.Pattern;

public class TokenWrapper {
    private final Token token;
    private final int line;
    private final int startPos;
    private final int endPos;
    private final Optional<String> value;

    public TokenWrapper(Token token, int line, int startPos, int endPos, Optional<String> value) {
        this.token = token;
        this.line = line;
        this.startPos = startPos;
        this.endPos = endPos;
        this.value = value;
    }

    public TokenName getName() {
        return token.getName();
    }

    public String toString() {
        return token.toString();
    }

    public Pattern getRegex() {
        return token.getRegex();
    }

    public boolean verify(String s) {
        return token.verify(s);
    }

    public int getLine() {
        return line;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public TokenGroup getGroup() {
        return token.getGroup();
    }

    public Optional<String> getValue() {
        return value;
    }
}
