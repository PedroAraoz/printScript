package edu.austral.ingsis;

public interface AbstractSyntaxTree extends Visitable {

    void add(AbstractSyntaxTree tree);

    void add(ValueAssignationSyntaxBranch branch);

    void add(TypeAssignationSyntaxBranch branch);

    void add(SumSubOperationSyntaxBranch branch);

    void add(MultDivOperationSyntaxBranch branch);

    void add(NumberTypeSyntaxLeaf leaf);

    void add(StringTypeSyntaxLeaf leaf);

    void add(VariableSyntaxLeaf leaf);

    void add(LiteralSyntaxLeaf leaf);
}
