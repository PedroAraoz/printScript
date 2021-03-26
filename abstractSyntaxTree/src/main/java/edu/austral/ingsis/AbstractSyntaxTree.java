package edu.austral.ingsis;

public interface AbstractSyntaxTree extends Visitable {

    void setTokenWrapper(TokenWrapper tokenWrapper);

    void add(AbstractSyntaxTree tree);

    void addValueAsignationSyntaxTree(ValueAssignationSyntaxBranch branch);

    void addTypeAsignationSyntaxTree(TypeAssignationSyntaxBranch branch);

    void addSumSubOperationSyntaxTree(SumSubOperationSyntaxBranch branch);

    void addMultDivOperationSyntaxTree(MultDivOperationSyntaxBranch branch);

    void addNumberTypeSyntaxLeaf(NumberTypeSyntaxLeaf leaf);

    void addStringTypeSyntaxLeaf(StringTypeSyntaxLeaf leaf);

    void addVariableSyntaxLeaf(VariableSyntaxLeaf leaf);

    void addLiteralSyntaxLeaf(LiteralSyntaxLeaf leaf);

    void addLetSyntaxLeaf(LetSyntaxLeaf leaf);

    boolean isEmpty();
}
