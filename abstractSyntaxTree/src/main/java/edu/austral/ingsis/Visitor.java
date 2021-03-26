package edu.austral.ingsis;

public interface Visitor {
  
  void visit(AbstractSyntaxTree abstractSyntaxTree);
  void visit(ValueAssignationSyntaxBranch branch);
  void visit(TypeAssignationSyntaxBranch branch);
  void visit(SumSubOperationSyntaxBranch branch);
  void visit(MultDivOperationSyntaxBranch branch);
  void visit(NumberTypeSyntaxLeaf leaf);
  void visit(StringTypeSyntaxLeaf leaf);
  void visit(VariableSyntaxLeaf leaf);
  void visit(LiteralSyntaxLeaf leaf);
}
