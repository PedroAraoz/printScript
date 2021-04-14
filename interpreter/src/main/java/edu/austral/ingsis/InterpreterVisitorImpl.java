package edu.austral.ingsis;

import java.util.Optional;

public class InterpreterVisitorImpl implements InterpreterVisitor {
  
  private final VariableRegister variableRegister = new VariableRegister();
  
  //todo falta agregar lo del printer que lo vas pasando
  @Override
  public AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree) {
    return abstractSyntaxTree.accept2(this);
  }
  
  @Override
  public AbstractSyntaxTree visitValueAssignation(ValueAssignationSyntaxBranch branch) {
    VariableSyntaxLeaf variableSyntaxLeaf = (VariableSyntaxLeaf) visit(branch.left);
    LiteralSyntaxLeaf literalSyntaxLeaf = (LiteralSyntaxLeaf) visit(branch.right);
    
    // TODO conseguir el tipo del literal
    variableRegister.assignValueToVariable(variableSyntaxLeaf.getToken().getValue(), literalSyntaxLeaf.getToken().getValue());
    return null; //todo esto esta raro
  }
  
  @Override
  public VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch) {
    String variableName = branch.left.getToken().getValue();
    TokenIdentifier type = branch.right.getToken().getTokenIdentifier();
    
    variableRegister.addNewVariable(variableName, type);
    
    return (VariableSyntaxLeaf) branch.left;
  }
  
  @Override
  public LiteralSyntaxLeaf visitSumSub(SumSubOperationSyntaxBranch branch) {
    final AbstractSyntaxTree l = visit(branch.left);
    final AbstractSyntaxTree r = visit(branch.right);
    final LiteralSyntaxLeaf left = smartCastToVariable(l);
    final LiteralSyntaxLeaf right = smartCastToVariable(r);
    if (isNumber(left) && isNumber(right)) {
      //only case when Literal will come out as number
      final int intAnswer =
              Integer.parseInt(left.getValue()) + Integer.parseInt(right.getValue());
      final String answer = Integer.toString(intAnswer);
      return getLiteralSyntaxLeaf(answer, TokenIdentifier.NUMBER_LITERAL_TOKEN);
    } else {
      //We can add them normally
      final String answer = left.getValue() + right.getValue();
      return getLiteralSyntaxLeaf(answer, TokenIdentifier.STRING_LITERAL_TOKEN);
    }
    
  }
  
  private LiteralSyntaxLeaf smartCastToVariable(AbstractSyntaxTree ast) {
    if (ast.getToken().getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN)) {
      final Optional<VariableInfo> optional = variableRegister.get(ast.getToken().getValue());
      if (optional.isPresent()) {
        final VariableInfo vi = optional.get();
        return getLiteralSyntaxLeaf(vi.getValue(), vi.getType());
      } else {
        //todo implement
        throw new Error();
      }
    } else {
      return (LiteralSyntaxLeaf) ast;
    }
  }
  
  @Override
  public LiteralSyntaxLeaf visitMultDiv(MultDivOperationSyntaxBranch branch) {
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    int answer;
    if (isNumber(left) && isNumber(right)) {
      if (branch.getToken().getTokenIdentifier().equals(TokenIdentifier.MULT_OPERATION_TOKEN)) {
        answer = Integer.parseInt(left.getValue()) *
                Integer.parseInt(right.getValue());
      } else {
        //si es div
        answer = Integer.parseInt(left.getValue()) /
                Integer.parseInt(right.getValue());
      }
      return getLiteralSyntaxLeaf(Integer.toString(answer), TokenIdentifier.NUMBER_TYPE_TOKEN);
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

  @Override
  public EmptySyntaxLeaf visitPrintLn(PrintLnSyntaxLeaf leaf) {
    // TODO implement
    return null;
  }

  @Override
  public EmptySyntaxLeaf visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf) {
    // This shouldn't happen
    return null;
  }

  @Override
  public EmptySyntaxLeaf visitRightParenthesis(RightParenthesisSyntaxLeaf leaf) {
    // This shouldn't happen
    return null;
  }

  private LiteralSyntaxLeaf getLiteralSyntaxLeaf(String value,  TokenIdentifier token) {
    final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
    literalSyntaxLeaf.setToken(
            new Token(token,
                    -1, -1, -1,
                    value));
    return literalSyntaxLeaf;
  }
  
  private boolean isNumber(LiteralSyntaxLeaf b) {
    return b.getToken().getTokenIdentifier().getName().equals(TokenName.NUMBER_LITERAL);
  }
  private boolean isString(LiteralSyntaxLeaf b) {
    return b.token.getTokenIdentifier().getName().equals(TokenName.STRING_LITERAL);
  }
  
  
  public void debug() {
    System.out.println("asd");
  }
}
//todo checkear que no puedas guardar un string en un int
