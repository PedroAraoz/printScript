package edu.austral.ingsis;

public interface Visitor {
  
  void visit(AssignationSyntaxBranch branch);
  void visit(OperationSyntaxBranch branch);
  void visit(DeclarationSyntaxLeaf leaf);
  void visit(LiteralSyntaxLeaf leaf);
}
