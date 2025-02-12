package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.util.Optional;

public class InterpreterVisitorImpl implements InterpreterVisitor {

  private final VariableRegister variableRegister = new VariableRegister();
  private final Printer printer;
  private boolean printEnabled;

  public InterpreterVisitorImpl(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void enablePrintProgress() {
    printEnabled = true;
  }

  @Override
  public void disablePrintProgress() {
    printEnabled = false;
  }

  @Override
  public AbstractSyntaxTree visit(AbstractSyntaxTree abstractSyntaxTree)
      throws CompilationTimeException {
    return abstractSyntaxTree.accept2(this);
  }

  @Override
  public AbstractSyntaxTree visitValueAssignation(ValueAssignationSyntaxBranch branch)
      throws CompilationTimeException {
    output("Handling value assignation");
    VariableSyntaxLeaf variableSyntaxLeaf = (VariableSyntaxLeaf) visit(branch.left);
    LiteralSyntaxLeaf literalSyntaxLeaf = (LiteralSyntaxLeaf) visit(branch.right);

    variableRegister.assignValueToVariable(
        variableSyntaxLeaf.getToken(), literalSyntaxLeaf.getToken());
    return branch;
  }

  private void output(String message) {
    if (printEnabled) printer.print(message);
  }

  @Override
  public VariableSyntaxLeaf visitTypeAssingation(TypeAssignationSyntaxBranch branch) {
    output("Handling type assignation");

    VariableSyntaxLeaf variableSyntaxLeaf = (VariableSyntaxLeaf) branch.left;

    String variableName = variableSyntaxLeaf.getToken().getValue();
    boolean isConst = variableSyntaxLeaf.isConst();
    TokenIdentifier type = branch.right.getToken().getTokenIdentifier();

    variableRegister.addNewVariable(variableName, type, isConst);

    return variableSyntaxLeaf;
  }

  @Override
  public LiteralSyntaxLeaf visitSumSub(SumSubOperationSyntaxBranch branch)
      throws CompilationTimeException {
    output("Handling sum/sub operation");
    final AbstractSyntaxTree l = visit(branch.left);
    final AbstractSyntaxTree r = visit(branch.right);
    final LiteralSyntaxLeaf left = smartCastToVariable(l);
    final LiteralSyntaxLeaf right = smartCastToVariable(r);

    int sumsub = 1;
    if (branch.token.getTokenIdentifier().equals(TokenIdentifier.SUB_OPERATION_TOKEN)) {
      sumsub = -1;
    }

    if (isNumber(left) && isNumber(right)) {
      // only case when Literal will come out as number
      final double doubleAnswer =
          Double.parseDouble(left.getValue()) + sumsub * Double.parseDouble(right.getValue());
      final String answer = Double.toString(doubleAnswer);
      return getLiteralSyntaxLeaf(answer, TokenIdentifier.NUMBER_LITERAL_TOKEN);
    } else if (sumsub == 1) {
      // We can add them normally
      final String answer = left.getValue() + right.getValue();
      return getLiteralSyntaxLeaf(answer, TokenIdentifier.STRING_LITERAL_TOKEN);
    } else {
      Token t = isString(left) ? left.getToken() : right.getToken();
      throw interpreterError("TODO FILE", t, "You can't substract with a string");
    }
  }

  private LiteralSyntaxLeaf smartCastToVariable(AbstractSyntaxTree ast)
      throws CompilationTimeException {
    if (ast.getToken().getTokenIdentifier().equals(TokenIdentifier.VARIABLE_TOKEN)) {
      final Optional<VariableInfo> optional = variableRegister.get(ast.getToken().getValue());
      if (optional.isPresent()) {
        final VariableInfo vi = optional.get();
        return getLiteralSyntaxLeaf(vi.getValue(), vi.getType());
      } else {

        throw interpreterError(
            "TODO ADD FILE", ast.getToken(), "Variable was not initialized"); // todo add file
      }
    } else {
      return (LiteralSyntaxLeaf) ast;
    }
  }

  @Override
  public LiteralSyntaxLeaf visitMultDiv(MultDivOperationSyntaxBranch branch)
      throws CompilationTimeException {
    output("Handling mult/div operation");

    final LiteralSyntaxLeaf left = smartCastToVariable(visit(branch.left));
    final LiteralSyntaxLeaf right = smartCastToVariable(visit(branch.right));
    double answer;
    if (isNumber(left) && isNumber(right)) {
      if (branch.getToken().getTokenIdentifier().equals(TokenIdentifier.MULT_OPERATION_TOKEN)) {
        answer = Double.parseDouble(left.getValue()) * Double.parseDouble(right.getValue());
      } else {
        // si es div
        answer = Double.parseDouble(left.getValue()) / Double.parseDouble(right.getValue());
      }
      return getLiteralSyntaxLeaf(Double.toString(answer), TokenIdentifier.NUMBER_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ? left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); // todo add file
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
  public LiteralSyntaxLeaf visitGreaterThan(GreaterThanOperationSyntaxBranch branch)
      throws CompilationTimeException {
    output("Handling 'Greater than' (>) operation");
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    String answer;
    if (isNumber(left) && isNumber(right)) {
      if (Double.parseDouble(left.getValue()) > Double.parseDouble(right.getValue())) {
        answer = "true";
      } else {
        answer = "false";
      }
      return getLiteralSyntaxLeaf(answer, TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ? left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); // todo add file
    }
  }

  @Override
  public LiteralSyntaxLeaf visitLesserThan(LesserThanOperationSyntaxBranch branch)
      throws CompilationTimeException {
    output("Handling 'Lesser than' (<) operation");
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    String answer;
    if (isNumber(left) && isNumber(right)) {
      if (Double.parseDouble(left.getValue()) < Double.parseDouble(right.getValue())) {
        answer = "true";
      } else {
        answer = "false";
      }
      return getLiteralSyntaxLeaf(answer, TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ? left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); // todo add file
    }
  }

  @Override
  public LiteralSyntaxLeaf visitLesserEqualThan(LesserEqualThanOperationSyntaxBranch branch)
      throws CompilationTimeException {
    output("Handling 'Lesser Equal than' (<=) operation");
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    String answer;
    if (isNumber(left) && isNumber(right)) {
      if (Double.parseDouble(left.getValue()) <= Double.parseDouble(right.getValue())) {
        answer = "true";
      } else {
        answer = "false";
      }
      return getLiteralSyntaxLeaf(answer, TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ? left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); // todo add file
    }
  }

  @Override
  public LiteralSyntaxLeaf visitGreaterEqualThan(GreaterEqualThanOperationSyntaxBranch branch)
      throws CompilationTimeException {
    output("Handling 'Greater Equal than' (<=) operation");
    final LiteralSyntaxLeaf left = (LiteralSyntaxLeaf) visit(branch.left);
    final LiteralSyntaxLeaf right = (LiteralSyntaxLeaf) visit(branch.right);
    String answer;
    if (isNumber(left) && isNumber(right)) {
      if (Double.parseDouble(left.getValue()) >= Double.parseDouble(right.getValue())) {
        answer = "true";
      } else {
        answer = "false";
      }
      return getLiteralSyntaxLeaf(answer, TokenIdentifier.BOOLEAN_LITERAL_TOKEN);
    } else {
      final Token t = !isNumber(left) ? left.getToken() : right.getToken();
      throw interpreterError("TODO ADD FILE", t, "Must be number"); // todo add file
    }
  }

  @Override
  public IfOperationSyntaxBranch visitIf(IfOperationSyntaxBranch branch)
      throws CompilationTimeException {
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

  private boolean getBooleanFromVariable(VariableSyntaxLeaf leaf) throws CompilationTimeException {
    if (variableRegister.contains(leaf.getValue())) {
      VariableInfo variableInfo = variableRegister.get(leaf.getValue()).get();
      if (variableInfo.getValue().isEmpty())
        throw new CompilationTimeException(
            "Variable not initialized in line "
                + leaf.getToken().getLine()
                + " in column "
                + leaf.getToken().getStartPos());
      if (!variableInfo.getType().equals(TokenIdentifier.BOOLEAN_TYPE_TOKEN))
        throw new CompilationTimeException(
            "If condition can only accept boolean variables. Line "
                + leaf.getToken().getLine()
                + ", column "
                + leaf.getToken().getStartPos());
      return variableInfo.getValue().equals("true");
    } else {
      throw new CompilationTimeException(
          "Undeclared variable in line "
              + leaf.getToken().getLine()
              + " in column "
              + leaf.getToken().getStartPos());
    }
  }

  @Override
  public AbstractSyntaxTree visitConst(ConstSyntaxLeaf constSyntaxLeaf) {
    return constSyntaxLeaf;
  }

  private LiteralSyntaxLeaf getLiteralSyntaxLeaf(String value, TokenIdentifier token) {
    final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
    literalSyntaxLeaf.setToken(new Token(token, -1, -1, -1, value));
    return literalSyntaxLeaf;
  }

  private boolean isNumber(LiteralSyntaxLeaf b) {
    return b.getToken().getTokenIdentifier().getName().equals(TokenName.NUMBER_LITERAL)
        || b.getToken().getTokenIdentifier().getName().equals(TokenName.NUMBER_TYPE);
  }

  private boolean isString(LiteralSyntaxLeaf b) {
    return b.token.getTokenIdentifier().getName().equals(TokenName.STRING_LITERAL);
  }

  private CompilationTimeException interpreterError(String file, Token token, String message) {
    return interpreterError(file, token.getLine(), token.getStartPos(), token.getEndPos(), message);
  }

  private CompilationTimeException interpreterError(
      String file, int line, int from, int to, String text) {
    final String message =
        "On File: "
            + file
            + "\n"
            + "line: "
            + line
            + "\n"
            + "from: "
            + from
            + " to: "
            + to
            + "\n"
            + "message: "
            + text;
    return new CompilationTimeException(message);
  }

  public void debug() {
    // System.out.println("debugging");
  }
}
