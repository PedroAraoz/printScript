package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Token {
    private final TokenName name;
    private final Pattern regex;

    public Token(TokenName name, Pattern regex) {
        this.name = name;
        this.regex = regex;
    }

    public TokenName getName() {
        return name;
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

    // STATIC

    public static Token LET_TOKEN =
            new Token(TokenName.LET, Pattern.compile("let"));
    public static Token TYPE_ASSIGNATION_TOKEN =
            new Token(TokenName.TYPE_ASSIGNATION, Pattern.compile(":"));
    public static Token SEMICOLON_TOKEN =
            new Token(TokenName.SEMICOLON, Pattern.compile(";"));
    public static Token VALUE_ASSIGNATION_TOKEN =
            new Token(TokenName.VALUE_ASSIGNATION, Pattern.compile("="));
    public static Token SUM_OPERATION_TOKEN =
            new Token(TokenName.SUM, Pattern.compile("\\+"));
    public static Token SUB_OPERATION_TOKEN =
            new Token(TokenName.SUB, Pattern.compile("-"));
    public static Token MULT_OPERATION_TOKEN =
            new Token(TokenName.MULT, Pattern.compile("\\*"));
    public static Token DIV_OPERATION_TOKEN =
            new Token(TokenName.DIV, Pattern.compile("/"));
    public static Token NUMBER_TYPE_TOKEN =
            new Token(TokenName.NUMBER_TYPE, Pattern.compile("number"));
    public static Token STRING_TYPE_TOKEN =
            new Token(TokenName.STRING_TYPE, Pattern.compile("string"));
    public static Token NUMBER_LITERAL_TOKEN =
            new Token(
                    TokenName.NUMBER_LITERAL,
                    Pattern.compile("[0-9]+|([0-9]+.[0-9]+)"));
    public static Token STRING_LITERAL_TOKEN =
            new Token(
                    TokenName.STRING_LITERAL,
                    Pattern.compile("('[a-zA-Z]+')|(\"[a-zA-Z]+\")"));
    public static Token VARIABLE_TOKEN =
            new Token(TokenName.VARIABLE, Pattern.compile(""));

    public static List<Token> getAllTokens() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(LET_TOKEN);
        tokens.add(TYPE_ASSIGNATION_TOKEN);
        tokens.add(SEMICOLON_TOKEN);
        tokens.add(VALUE_ASSIGNATION_TOKEN);
        tokens.add(SUM_OPERATION_TOKEN);
        tokens.add(SUB_OPERATION_TOKEN);
        tokens.add(MULT_OPERATION_TOKEN);
        tokens.add(DIV_OPERATION_TOKEN);
        tokens.add(NUMBER_TYPE_TOKEN);
        tokens.add(STRING_TYPE_TOKEN);
        return tokens;
    }
}
