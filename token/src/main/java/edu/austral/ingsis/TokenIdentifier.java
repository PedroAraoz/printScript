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
    public static TokenIdentifier NUMBER_LITERAL_TOKEN =
            new TokenIdentifier(
                    TokenName.NUMBER_LITERAL,
                    Pattern.compile("([0-9]+.[0-9]+)|[0-9]+"));
    public static TokenIdentifier STRING_LITERAL_TOKEN =
            new TokenIdentifier(
                    TokenName.STRING_LITERAL,
                    Pattern.compile("('[a-zA-Z ]+')|(\"[a-zA-Z ]+\")"));
    public static TokenIdentifier VARIABLE_TOKEN =
            new TokenIdentifier(TokenName.VARIABLE, Pattern.compile(""));
    public static TokenIdentifier PRINTLN_TOKEN =
            new TokenIdentifier(TokenName.PRINT, Pattern.compile("printLn"));
    public static TokenIdentifier LEFT_PARENTHESIS_TOKEN =
            new TokenIdentifier(TokenName.LEFT_PARENTHESIS, Pattern.compile("\\("));
    public static TokenIdentifier RIGHT_PARENTHESIS_TOKEN =
            new TokenIdentifier(TokenName.RIGHT_PARENTHESIS, Pattern.compile("\\)"));
    public static TokenIdentifier WIP_TOKEN =
            new TokenIdentifier(TokenName.WIP_TOKEN, Pattern.compile(".*"));

    public static List<TokenIdentifier> getAllTokens(String version) {
        List<TokenIdentifier> tokenIdentifiers = new ArrayList<>();
        tokenIdentifiers.addAll(getPriorityOneTokens());
        tokenIdentifiers.addAll(getPriorityTwoTokens());
        tokenIdentifiers.addAll(getPriorityThreeTokens());
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
        return tokenIdentifiers;
    }
    
    public static List<TokenIdentifier> getPriorityOneTokens() {
        List<TokenIdentifier> tokens = new ArrayList<>();
        tokens.add(TYPE_ASSIGNATION_TOKEN);
        tokens.add(SEMICOLON_TOKEN);
        tokens.add(VALUE_ASSIGNATION_TOKEN);
        tokens.add(SUM_OPERATION_TOKEN);
        tokens.add(SUB_OPERATION_TOKEN);
        tokens.add(MULT_OPERATION_TOKEN);
        tokens.add(DIV_OPERATION_TOKEN);
        tokens.add(LEFT_PARENTHESIS_TOKEN);
        tokens.add(RIGHT_PARENTHESIS_TOKEN);
        return tokens;
    }
    
    public static List<TokenIdentifier> getPriorityTwoTokens() {
        List<TokenIdentifier> tokens = new ArrayList<>();
        tokens.add(STRING_LITERAL_TOKEN);
        tokens.add(NUMBER_LITERAL_TOKEN);
        return tokens;
    }
    
    public static List<TokenIdentifier> getPriorityThreeTokens() {
        List<TokenIdentifier> tokens = new ArrayList<>();
        tokens.add(LET_TOKEN);
        tokens.add(NUMBER_TYPE_TOKEN);
        tokens.add(STRING_TYPE_TOKEN);
        tokens.add(PRINTLN_TOKEN);
        tokens.add(VARIABLE_TOKEN);
        return tokens;
    }
    
}
