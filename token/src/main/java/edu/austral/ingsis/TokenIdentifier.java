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

    public static TokenIdentifier letTokenIdentifier =
            new TokenIdentifier(TokenName.LET, Pattern.compile("let"));
    public static TokenIdentifier typeAssignationTokenIdentifier =
            new TokenIdentifier(TokenName.TYPE_ASSIGNATION, Pattern.compile(":"));
    public static TokenIdentifier semicolonTokenIdentifier =
            new TokenIdentifier(TokenName.SEMICOLON, Pattern.compile(";"));
    public static TokenIdentifier valueAssignationTokenIdentifier =
            new TokenIdentifier(TokenName.VALUE_ASSIGNATION, Pattern.compile("="));
    public static TokenIdentifier sumOperationTokenIdentifier =
            new TokenIdentifier(TokenName.SUM, Pattern.compile("\\+"));
    public static TokenIdentifier subOperationTokenIdentifier =
            new TokenIdentifier(TokenName.SUB, Pattern.compile("-"));
    public static TokenIdentifier multOperationTokenIdentifier =
            new TokenIdentifier(TokenName.MULT, Pattern.compile("\\*"));
    public static TokenIdentifier divOperationTokenIdentifier =
            new TokenIdentifier(TokenName.DIV, Pattern.compile("/"));
    public static TokenIdentifier numberTypeTokenIdentifier =
            new TokenIdentifier(TokenName.NUMBER_TYPE, Pattern.compile("number"));
    public static TokenIdentifier stringTypeTokenIdentifier =
            new TokenIdentifier(TokenName.STRING_TYPE, Pattern.compile("string"));
    public static TokenIdentifier numberLiteralTokenIdentifier =
            new TokenIdentifier(
                    TokenName.NUMBER_LITERAL,
                    Pattern.compile("[0-9]+|([0-9]+.[0-9]+)"));
    public static TokenIdentifier stringLiteralTokenIdentifier =
            new TokenIdentifier(
                    TokenName.STRING_LITERAL,
                    Pattern.compile("('[a-zA-Z]+')|(\"[a-zA-Z]+\")"));
    public static TokenIdentifier variableTokenIdentifier =
            new TokenIdentifier(TokenName.VARIABLE, Pattern.compile(""));

    public static List<TokenIdentifier> getAllTokens() {
        List<TokenIdentifier> tokenIdentifiers = new ArrayList<>();
        tokenIdentifiers.add(letTokenIdentifier);
        tokenIdentifiers.add(typeAssignationTokenIdentifier);
        tokenIdentifiers.add(semicolonTokenIdentifier);
        tokenIdentifiers.add(valueAssignationTokenIdentifier);
        tokenIdentifiers.add(sumOperationTokenIdentifier);
        tokenIdentifiers.add(subOperationTokenIdentifier);
        tokenIdentifiers.add(multOperationTokenIdentifier);
        tokenIdentifiers.add(divOperationTokenIdentifier);
        tokenIdentifiers.add(numberTypeTokenIdentifier);
        tokenIdentifiers.add(stringTypeTokenIdentifier);
        return tokenIdentifiers;
    }
}
