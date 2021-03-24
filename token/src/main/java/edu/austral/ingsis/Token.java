package edu.austral.ingsis;

import java.util.regex.Pattern;

public class Token {
    private final TokenName name;
    private final TokenGroup group;
    private final Pattern regex;

    public Token(TokenName name, TokenGroup group, Pattern regex) {
        this.name = name;
        this.group = group;
        this.regex = regex;
    }

    public TokenName getName() {
        return name;
    }

    public TokenGroup getGroup() {
        return group;
    }

    public Pattern getRegex() {
        return regex;
    }

    public String toString() {
        return name.toString();
    }

    public boolean verify(String s) {
        return regex.matcher(s).matches();
    }
}
