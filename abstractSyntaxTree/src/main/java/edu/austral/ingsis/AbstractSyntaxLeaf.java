package edu.austral.ingsis;

public abstract class AbstractSyntaxLeaf implements AbstractSyntaxTree {

    private TokenWrapper tokenWrapper;

    public TokenWrapper getTokenWrapper() {
        return tokenWrapper;
    }
}
