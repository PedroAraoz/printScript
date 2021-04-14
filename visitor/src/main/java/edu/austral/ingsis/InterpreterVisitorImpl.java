package edu.austral.ingsis;

public class InterpreterVisitorImpl implements InterpreterVisitor {
  
  private final VariableRegister variableRegister = new VariableRegister();
  
  @Override
  public AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree) {
//        return abstractSyntaxTree.accept2(this);
    return null;
  }
  
  @Override
  public void visitValueAssignation(ValueAssignationSyntaxBranch branch) {
    VariableSyntaxLeaf variableSyntaxLeaf = (VariableSyntaxLeaf) visit(branch.left);
    LiteralSyntaxLeaf literalSyntaxLeaf = (LiteralSyntaxLeaf) visit(branch.right);
    
    // TODO conseguir el tipo del literal
    variableRegister.assignValueToVariable(variableSyntaxLeaf.getTokenWrapper().getValue(), literalSyntaxLeaf.getTokenWrapper().getValue());
  }
  
  @Override
  public VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch) {
    String variableName = branch.left.getTokenWrapper().getValue();
    TokenIdentifier type = branch.right.getTokenWrapper().getToken();
    
    variableRegister.addNewVariable(variableName, type);
    
    return (VariableSyntaxLeaf) branch.left;
  }
  
  @Override
  public LiteralSyntaxLeaf visitSumSub(SumSubOperationSyntaxBranch branch) {
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    final String answer;
    if (isNumber(left) && isNumber(right)) {
      //only case when Literal will come out as number
      final int intAnswer =
              Integer.parseInt(left.getValue()) + Integer.parseInt(right.getValue());
      answer = Integer.toString(intAnswer);
    } else {
      //We can add them normally
      answer = left.getValue() + right.getValue();
    }
    return getLiteralSyntaxLeaf(answer, TokenIdentifier.numberLiteralTokenIdentifier);
  }
  
  @Override
  public LiteralSyntaxLeaf visitMultDiv(MultDivOperationSyntaxBranch branch) {
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    int answer;
    if (isNumber(left) && isNumber(right)) {
      if (branch.getTokenWrapper().getToken().equals(TokenIdentifier.multOperationTokenIdentifier)) {
        answer = Integer.parseInt(left.getValue()) *
                Integer.parseInt(right.getValue());
      } else {
        //si es div
        answer = Integer.parseInt(left.getValue()) /
                Integer.parseInt(right.getValue());
      }
      return getLiteralSyntaxLeaf(Integer.toString(answer), TokenIdentifier.numberTypeTokenIdentifier);
    } else {
      //todo tirar error
      throw new Error();
    }
  }
  
  @Override
  public NumberTypeSyntaxLeaf visitNumberType(NumberTypeSyntaxLeaf leaf) {
    return leaf;
  }
  
  @Override
  public StringTypeSyntaxLeaf visitStringType(StringTypeSyntaxLeaf leaf) {
    return leaf;
  }
  
  @Override
  public VariableSyntaxLeaf visitVariable(VariableSyntaxLeaf leaf) {
    return leaf;
  }
  
  @Override
  public LiteralSyntaxLeaf visitLiteral(LiteralSyntaxLeaf leaf) {
    return leaf;
  }
  
  @Override
  public EmptySyntaxLeaf visitEmpty(EmptySyntaxLeaf leaf) {
    return leaf;
  }
  
  private LiteralSyntaxLeaf getLiteralSyntaxLeaf(String value,  TokenIdentifier tokenIdentifier) {
    final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
    literalSyntaxLeaf.setTokenWrapper(
            new Token(tokenIdentifier,
                    -1, -1, -1,
                    value));
    return literalSyntaxLeaf;
  }
  
  private boolean isNumber(LiteralSyntaxLeaf b) {
    return b.token.getToken().getName().equals(TokenName.NUMBER_LITERAL);
  }
  private boolean isString(LiteralSyntaxLeaf b) {
    return b.token.getToken().getName().equals(TokenName.STRING_LITERAL);
  }
}
