package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public interface InterpreterVisitor {

    AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree);
    
    AbstractSyntaxTree visitValueAssignation(ValueAssignationSyntaxBranch branch);

    VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch);
    
    LiteralSyntaxLeaf visitSumSub(SumSubOperationSyntaxBranch branch) throws CompilationTimeException;

    LiteralSyntaxLeaf visitMultDiv(MultDivOperationSyntaxBranch branch) throws CompilationTimeException;
    
    NumberTypeSyntaxLeaf visitNumberType(NumberTypeSyntaxLeaf leaf);
    
    StringTypeSyntaxLeaf visitStringType(StringTypeSyntaxLeaf leaf);
    
    VariableSyntaxLeaf visitVariable(VariableSyntaxLeaf leaf);
    
    LiteralSyntaxLeaf visitLiteral(LiteralSyntaxLeaf leaf);
    
    EmptySyntaxLeaf visitEmpty(EmptySyntaxLeaf leaf);

    EmptySyntaxLeaf visitPrintLn(PrintLnSyntaxLeaf leaf) throws CompilationTimeException;

    EmptySyntaxLeaf visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf);

    EmptySyntaxLeaf visitRightParenthesis(RightParenthesisSyntaxLeaf leaf);
}
