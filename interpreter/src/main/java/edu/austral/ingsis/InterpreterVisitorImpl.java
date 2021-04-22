package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.Optional;

public class InterpreterVisitorImpl implements InterpreterVisitor {
  
  private final VariableRegister variableRegister = new VariableRegister();
  private final Printer printer;
  
  public InterpreterVisitorImpl(Printer printer) {
    this.printer = printer;
  }
  
  @Override
  public AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException {
    return abstractSyntaxTree.accept2(this);
  }
  
  @Override
  public AbstractSyntaxTree visitValueAssignation(ValueAssignationSyntaxBranch branch) throws CompilationTimeException {
    printer.print("handling value assignation");
    VariableSyntaxLeaf variableSyntaxLeaf = (VariableSyntaxLeaf) visit(branch.left);
    LiteralSyntaxLeaf literalSyntaxLeaf = (LiteralSyntaxLeaf) visit(branch.right);

    if (variableSyntaxLeaf.isConst()) throw new CompilationTimeException("Cannot assign value to variable " + variableSyntaxLeaf.getValue() + " in line " + variableSyntaxLeaf.getToken().getLine() + " in column " + variableSyntaxLeaf.getToken().getStartPos());
    variableRegister.assignValueToVariable(variableSyntaxLeaf.getToken(), literalSyntaxLeaf.getToken());
    return null; //todo esto esta raro
  }
  
  @Override
  public VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch) {
    printer.print("handling type assignation");
    String variableName = branch.left.getToken().getValue();
    TokenIdentifier type = branch.right.getToken().getTokenIdentifier();
    
    variableRegister.addNewVariable(variableName, type);
    
    return (VariableSyntaxLeaf) branch.left;
  }
  
  @Override
  public LiteralSyntaxLeaf visitSumSub(SumSubOperationSyntaxBranch branch) throws CompilationTimeException {
    printer.print("handling sum/sub operation");
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
  
  private LiteralSyntaxLeaf smartCastToVariable(AbstractSyntaxTree ast) throws CompilationTimeException {
    if (ast.getToken().getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN)) {
      final Optional<VariableInfo> optional = variableRegister.get(ast.getToken().getValue());
      if (optional.isPresent()) {
        final VariableInfo vi = optional.get();
        return getLiteralSyntaxLeaf(vi.getValue(), vi.getType());
      } else {
        
        throw interpreterError("TODO ADD FILE", ast.getToken(), "Variable was not initialized"); //todo add file
      }
    } else {
      return (LiteralSyntaxLeaf) ast;
    }
  }
  
  @Override
  public LiteralSyntaxLeaf visitMultDiv(MultDivOperationSyntaxBranch branch) throws CompilationTimeException {
    printer.print("handling mult/div operation");
    
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
      return getLiteralSyntaxLeaf(Integer.toString(answer), TokenIdentifier.NUMBER_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ?
              left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); //todo add file
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
  public PrintLnSyntaxLeaf visitPrintLn(PrintLnSyntaxLeaf leaf) throws CompilationTimeException {
    AbstractSyntaxTree expression = leaf.getExpression();
    LiteralSyntaxLeaf result = smartCastToVariable(visit(expression));
    printer.print(result.getValue());
    return leaf;
  }
  
  @Override
  public LeftParenthesisSyntaxLeaf visitLeftParenthesis(LeftParenthesisSyntaxLeaf leaf) {
    // This shouldn't happen
    return null;
  }
  
  @Override
  public RightParenthesisSyntaxLeaf visitRightParenthesis(RightParenthesisSyntaxLeaf leaf) {
    // This shouldn't happen
    return null;
  }

  @Override
  public BooleanTypeSyntaxLeaf visitBooleanType(BooleanTypeSyntaxLeaf leaf) {
    return leaf;
  }

  @Override
  public LiteralSyntaxLeaf visitGreaterThan(GreaterThanOperationSyntaxBranch branch) throws CompilationTimeException {
    printer.print("handling 'Greater than' (>) operation");
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    int answer;
    if (isNumber(left) && isNumber(right)) {
      if (Integer.parseInt(left.getValue()) > Integer.parseInt(right.getValue())) {
        answer = 1;
      } else {
        answer = 0;
      }
      return getLiteralSyntaxLeaf(Integer.toString(answer), TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ?
              left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); //todo add file
    }
  }

  @Override
  public LiteralSyntaxLeaf visitLesserThan(LesserThanOperationSyntaxBranch branch) throws CompilationTimeException {
    printer.print("handling 'Lesser than' (<) operation");
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    int answer;
    if (isNumber(left) && isNumber(right)) {
      if (Integer.parseInt(left.getValue()) < Integer.parseInt(right.getValue())) {
        answer = 1;
      } else {
        answer = 0;
      }
      return getLiteralSyntaxLeaf(Integer.toString(answer), TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ?
              left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); //todo add file
    }
  }

  @Override
  public LiteralSyntaxLeaf visitLesserEqualThan(LesserEqualThanOperationSyntaxBranch branch) throws CompilationTimeException {
    printer.print("handling 'Lesser Equal than' (<=) operation");
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    int answer;
    if (isNumber(left) && isNumber(right)) {
      if (Integer.parseInt(left.getValue()) <= Integer.parseInt(right.getValue())) {
        answer = 1;
      } else {
        answer = 0;
      }
      return getLiteralSyntaxLeaf(Integer.toString(answer), TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ?
              left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); //todo add file
    }
  }

  @Override
  public LiteralSyntaxLeaf visitGreaterEqualThan(GreaterEqualThanOperationSyntaxBranch branch) throws CompilationTimeException {
    printer.print("handling 'Greater Equal than' (<=) operation");
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    int answer;
    if (isNumber(left) && isNumber(right)) {
      if (Integer.parseInt(left.getValue()) >= Integer.parseInt(right.getValue())) {
        answer = 1;
      } else {
        answer = 0;
      }
      return getLiteralSyntaxLeaf(Integer.toString(answer), TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ?
              left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); //todo add file
    }
  }

  @Override
  public IfOperationSyntaxBranch visitIf(IfOperationSyntaxBranch branch) throws CompilationTimeException {
    VariableSyntaxLeaf leaf = branch.getCondition();
    boolean b = getBooleanFromVariable(leaf);
    if (b) {
      for (AbstractSyntaxTree tree : branch.get_if()) {
        visit(tree);
      }
    } else {
      for (AbstractSyntaxTree tree : branch.get_else()) {
        visit(tree);
      }
    }
    return branch;
  }

  // TODO Chequear si esto esta bien hecho o si ya hay algo mas lindo
  private boolean getBooleanFromVariable(VariableSyntaxLeaf leaf) throws CompilationTimeException {
    if (variableRegister.contains(leaf.getValue())) {
      VariableInfo variableInfo = variableRegister.get(leaf.getValue()).get();
      if (variableInfo.getValue().isEmpty())
        throw new CompilationTimeException("Variable not initialized in line " + leaf.getToken().getLine() + " in column " + leaf.getToken().getStartPos());
      return variableInfo.getValue().equals("true");
    } else {
      throw new CompilationTimeException("Undeclared variable in line " + leaf.getToken().getLine() + " in column " + leaf.getToken().getStartPos());
    }
  }

  @Override
  public AbstractSyntaxTree visitConst(ConstSyntaxLeaf constSyntaxLeaf) {
    return constSyntaxLeaf;
  }

  private LiteralSyntaxLeaf getLiteralSyntaxLeaf(String value, TokenIdentifier token) {
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
  
  private CompilationTimeException interpreterError(String file, Token token, String message) {
    return interpreterError(file, token.getLine(), token.getStartPos(), token.getEndPos(), message);
  }
  
  private CompilationTimeException interpreterError(String file, int line, int from, int to, String text) {
    final String message = "On File: " + file + "\n" +
            "line: " + line + "\n" +
            "from: " + from + " to: " + to + "\n" +
            "message: " + text;
    return new CompilationTimeException(message);
  }
  
  
  public void debug() {
    System.out.println("debugging");
  }
}
//todo checkear que no puedas guardar un string en un int
