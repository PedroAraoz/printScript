package edu.austral.ingsis;

public abstract class AbstractSyntaxBranch implements AbstractSyntaxTree {

    protected AbstractSyntaxTree left = new LetSyntaxLeaf();
    protected TokenWrapper tokenWrapper;
    protected AbstractSyntaxTree right = new LetSyntaxLeaf();

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

    public boolean isEmpty() {
        return false;
    }

    protected void addRight(AbstractSyntaxTree tree) {
        if (this.right.isEmpty()) {
            this.right = tree;
        } else {
            right.add(tree);
        }
    }

    protected void addLeft(AbstractSyntaxTree tree) {
        if (this.left.isEmpty()) {
            this.left = tree;
        } else {
            left.add(tree);
        }
    }
}
