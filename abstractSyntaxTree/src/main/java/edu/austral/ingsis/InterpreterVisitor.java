package edu.austral.ingsis;

public interface InterpreterVisitor {

    AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree);
    
    AbstractSyntaxTree visitValueAssignation(ValueAssignationSyntaxBranch branch);

    VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch);
    
    LiteralSyntaxLeaf visitSumSub(SumSubOperationSyntaxBranch branch);

    LiteralSyntaxLeaf visitMultDiv(MultDivOperationSyntaxBranch branch);
    
    NumberTypeSyntaxLeaf visitNumberType(NumberTypeSyntaxLeaf leaf);
    
    StringTypeSyntaxLeaf visitStringType(StringTypeSyntaxLeaf leaf);
    
    VariableSyntaxLeaf visitVariable(VariableSyntaxLeaf leaf);
    
    LiteralSyntaxLeaf visitLiteral(LiteralSyntaxLeaf leaf);
    
    EmptySyntaxLeaf visitEmpty(EmptySyntaxLeaf leaf);
}
