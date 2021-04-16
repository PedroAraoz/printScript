package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

public interface InterpreterVisitor {

    AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException;
    
    AbstractSyntaxTree visitValueAssignation(ValueAssignationSyntaxBranch branch) throws CompilationTimeException;

    VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch);
    
    LiteralSyntaxLeaf visitSumSub(SumSubOperationSyntaxBranch branch) throws CompilationTimeException;

    LiteralSyntaxLeaf visitMultDiv(MultDivOperationSyntaxBranch branch) throws CompilationTimeException;
    
    NumberTypeSyntaxLeaf visitNumberType(NumberTypeSyntaxLeaf leaf);
    
    StringTypeSyntaxLeaf visitStringType(StringTypeSyntaxLeaf leaf);
    
    VariableSyntaxLeaf visitVariable(VariableSyntaxLeaf leaf);
    
    LiteralSyntaxLeaf visitLiteral(LiteralSyntaxLeaf leaf);
    
    EmptySyntaxLeaf visitEmpty(EmptySyntaxLeaf leaf);

    PrintLnSyntaxLeaf visitPrintLn(PrintLnSyntaxLeaf leaf) throws CompilationTimeException;

    LeftParenthesisSyntaxLeaf visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf);

    RightParenthesisSyntaxLeaf visitRightParenthesis(RightParenthesisSyntaxLeaf leaf);

    BooleanTypeSyntaxLeaf visitBooleanType(BooleanTypeSyntaxLeaf leaf);

    GreaterThanOperationSyntaxBranch visitGreaterThan(GreaterThanOperationSyntaxBranch branch);

    LesserThanOperationSyntaxBranch visitLesserThan(LesserThanOperationSyntaxBranch branch);

    LesserEqualThanOperationSyntaxBranch visitLesserEqualThan(LesserEqualThanOperationSyntaxBranch branch);

    GreaterEqualThanOperationSyntaxBranch visitGreaterEqualThan(GreaterEqualThanOperationSyntaxBranch branch);

    LeftBracketSyntaxLeaf visitLeftBracket(LeftBracketSyntaxLeaf leaf);

    RightBracketSyntaxLeaf visitRightBracket(RightBracketSyntaxLeaf leaf);

    IfElseOperationSyntaxBranch visitIfElse(IfElseOperationSyntaxBranch branch);
}
