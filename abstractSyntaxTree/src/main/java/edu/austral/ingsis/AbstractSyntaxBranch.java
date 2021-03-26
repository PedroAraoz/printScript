package edu.austral.ingsis;

public abstract class AbstractSyntaxBranch implements AbstractSyntaxTree {

    private AbstractSyntaxTree left;
    private TokenWrapper tokenWrapper;
    private AbstractSyntaxTree right;

    public AbstractSyntaxTree getLeft() {
        return left;
    }

    public TokenWrapper getTokenWrapper() {
        return tokenWrapper;
    }

    public AbstractSyntaxTree getRight() {
        return right;
    }
}
