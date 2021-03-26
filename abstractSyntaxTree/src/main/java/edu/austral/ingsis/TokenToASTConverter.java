package edu.austral.ingsis;

import java.util.HashMap;

public class TokenToASTConverter {

    final HashMap<Token, AbstractSyntaxTree> map = new HashMap<>();

    public TokenToASTConverter() {

        this.map.put(Token.LET_TOKEN, new EmptySyntaxLeaf());
        this.map.put(Token.TYPE_ASSIGNATION_TOKEN, new TypeAssignationSyntaxBranch());


    }

    public AbstractSyntaxTree convert(TokenWrapper tokenWrapper) {
        return map.get(tokenWrapper.getToken());
    }
}
