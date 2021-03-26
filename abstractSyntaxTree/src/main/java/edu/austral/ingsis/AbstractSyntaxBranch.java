package edu.austral.ingsis;

public abstract class AbstractSyntaxBranch implements AbstractSyntaxTree {

    protected AbstractSyntaxTree left = new EmptySyntaxLeaf();
    protected TokenWrapper tokenWrapper;
    protected AbstractSyntaxTree right = new EmptySyntaxLeaf();

    public void setTokenWrapper(TokenWrapper tokenWrapper) {
        this.tokenWrapper = tokenWrapper;
    }

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
