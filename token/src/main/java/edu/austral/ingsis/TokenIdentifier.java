package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TokenIdentifier {
    private final TokenName name;
    private final Pattern regex;

    public TokenIdentifier(TokenName name, Pattern regex) {
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

    public static TokenIdentifier LET_TOKEN =
            new TokenIdentifier(TokenName.LET, Pattern.compile("let"));
    public static TokenIdentifier TYPE_ASSIGNATION_TOKEN =
            new TokenIdentifier(TokenName.TYPE_ASSIGNATION, Pattern.compile(":"));
    public static TokenIdentifier SEMICOLON_TOKEN =
            new TokenIdentifier(TokenName.SEMICOLON, Pattern.compile(";"));
    public static TokenIdentifier VALUE_ASSIGNATION_TOKEN =
            new TokenIdentifier(TokenName.VALUE_ASSIGNATION, Pattern.compile("="));
    public static TokenIdentifier SUM_OPERATION_TOKEN =
            new TokenIdentifier(TokenName.SUM, Pattern.compile("\\+"));
    public static TokenIdentifier SUB_OPERATION_TOKEN =
            new TokenIdentifier(TokenName.SUB, Pattern.compile("-"));
    public static TokenIdentifier MULT_OPERATION_TOKEN =
            new TokenIdentifier(TokenName.MULT, Pattern.compile("\\*"));
    public static TokenIdentifier DIV_OPERATION_TOKEN =
            new TokenIdentifier(TokenName.DIV, Pattern.compile("/"));
    public static TokenIdentifier NUMBER_TYPE_TOKEN =
            new TokenIdentifier(TokenName.NUMBER_TYPE, Pattern.compile("number"));
    public static TokenIdentifier STRING_TYPE_TOKEN =
            new TokenIdentifier(TokenName.STRING_TYPE, Pattern.compile("string"));
    public static TokenIdentifier BOOLEAN_TYPE_TOKEN =
            new TokenIdentifier(TokenName.BOOLEAN_TYPE, Pattern.compile("boolean"));
    public static TokenIdentifier NUMBER_LITERAL_TOKEN =
            new TokenIdentifier(
                    TokenName.NUMBER_LITERAL,
                    Pattern.compile("[0-9]+|([0-9]+.[0-9]+)"));
    public static TokenIdentifier STRING_LITERAL_TOKEN =
            new TokenIdentifier(
                    TokenName.STRING_LITERAL,
                    Pattern.compile("('[a-zA-Z]+')|(\"[a-zA-Z]+\")"));
    public static TokenIdentifier TRUE_TOKEN =
            new TokenIdentifier(
                    TokenName.TRUE,
                    Pattern.compile("true"));
    public static TokenIdentifier FALSE_TOKEN =
            new TokenIdentifier(
                    TokenName.FALSE,
                    Pattern.compile("false"));
    public static TokenIdentifier VARIABLE_TOKEN =
            new TokenIdentifier(TokenName.VARIABLE, Pattern.compile(""));
    public static TokenIdentifier PRINTLN_TOKEN =
            new TokenIdentifier(TokenName.PRINT, Pattern.compile("printLn"));
    public static TokenIdentifier LEFT_PARENTHESIS_TOKEN =
            new TokenIdentifier(TokenName.LEFT_PARENTHESIS, Pattern.compile("\\("));
    public static TokenIdentifier RIGHT_PARENTHESIS_TOKEN =
            new TokenIdentifier(TokenName.RIGHT_PARENTHESIS, Pattern.compile("\\)"));
    public static TokenIdentifier CONST_TOKEN =
            new TokenIdentifier(TokenName.CONST, Pattern.compile("const"));
    public static TokenIdentifier IF_TOKEN =
            new TokenIdentifier(TokenName.IF, Pattern.compile("if"));
    public static TokenIdentifier ELSE_TOKEN =
            new TokenIdentifier(TokenName.ELSE, Pattern.compile("else"));
    public static TokenIdentifier LEFT_BRACKET_TOKEN =
            new TokenIdentifier(TokenName.LEFT_BRACKET, Pattern.compile("\\{"));
    public static TokenIdentifier RIGHT_BRACKET_TOKEN =
            new TokenIdentifier(TokenName.RIGHT_BRACKET, Pattern.compile("}"));
    public static TokenIdentifier GREATER_TOKEN =
            new TokenIdentifier(TokenName.GREATER, Pattern.compile(">"));
    public static TokenIdentifier LESSER_TOKEN =
            new TokenIdentifier(TokenName.LESSER, Pattern.compile("<"));
    public static TokenIdentifier GREATER_EQUALS_TOKEN =
            new TokenIdentifier(TokenName.GREATER_EQUAL, Pattern.compile(">="));
    public static TokenIdentifier LESSER_EQUALS_TOKEN =
            new TokenIdentifier(TokenName.LESSER_EQUAL, Pattern.compile("<="));

    public static List<TokenIdentifier> getAllTokens(String version) {
        List<TokenIdentifier> tokenIdentifiers = new ArrayList<>();
        tokenIdentifiers.add(LET_TOKEN);
        tokenIdentifiers.add(TYPE_ASSIGNATION_TOKEN);
        tokenIdentifiers.add(SEMICOLON_TOKEN);
        tokenIdentifiers.add(VALUE_ASSIGNATION_TOKEN);
        tokenIdentifiers.add(SUM_OPERATION_TOKEN);
        tokenIdentifiers.add(SUB_OPERATION_TOKEN);
        tokenIdentifiers.add(MULT_OPERATION_TOKEN);
        tokenIdentifiers.add(DIV_OPERATION_TOKEN);
        tokenIdentifiers.add(NUMBER_TYPE_TOKEN);
        tokenIdentifiers.add(STRING_TYPE_TOKEN);
        tokenIdentifiers.add(PRINTLN_TOKEN);
        tokenIdentifiers.add(LEFT_PARENTHESIS_TOKEN);
        tokenIdentifiers.add(RIGHT_PARENTHESIS_TOKEN);
        if (version.equals("1.1")) {
            tokenIdentifiers.add(BOOLEAN_TYPE_TOKEN);
            tokenIdentifiers.add(TRUE_TOKEN);
            tokenIdentifiers.add(FALSE_TOKEN);
            tokenIdentifiers.add(CONST_TOKEN);
            tokenIdentifiers.add(IF_TOKEN);
            tokenIdentifiers.add(ELSE_TOKEN);
            tokenIdentifiers.add(LEFT_BRACKET_TOKEN);
            tokenIdentifiers.add(RIGHT_BRACKET_TOKEN);
            tokenIdentifiers.add(GREATER_TOKEN);
            tokenIdentifiers.add(GREATER_EQUALS_TOKEN);
            tokenIdentifiers.add(LESSER_TOKEN);
            tokenIdentifiers.add(LESSER_EQUALS_TOKEN);
        }
        return tokenIdentifiers;
    }
}
