//import edu.austral.ingsis.*;
//import edu.austral.ingsis.exception.CompilationTimeException;
//import org.junit.Test;
//
//public class InterpreterTests {
//
//    @Test
//    public void interpretationOfAnEmptyASTShouldReturnAnEmptyList() {
//        Interpreter interpreter = new InterpreterImpl(new VariableRegister());
//        assert interpreter.interpret(new EmptySyntaxLeaf()).isEmpty();
//    }
//
//    @Test
//    public void declarationOfAVariableShouldBeAddedToRegister() throws CompilationTimeException {
//        String variableName = "x";
//
//        final AbstractSyntaxTree declaration = new TypeAssignationSyntaxBranch();
//        declaration.setTokenWrapper(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
//
//        final VariableSyntaxLeaf variable = new VariableSyntaxLeaf();
//        variable.setTokenWrapper(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, variableName));
//        declaration.addVariableSyntaxLeaf(variable);
//
//        final StringTypeSyntaxLeaf stringTypeSyntaxLeaf = new StringTypeSyntaxLeaf();
//        stringTypeSyntaxLeaf.setTokenWrapper(new TokenWrapper(Token.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
//        declaration.addStringTypeSyntaxLeaf(stringTypeSyntaxLeaf);
//
//        final VariableRegister variableRegister = new VariableRegister();
//
//        final Interpreter interpreter = new InterpreterImpl(variableRegister);
//
//        interpreter.interpret(declaration);
//
//        assert variableRegister.contains(variableName);
//    }
//
//    @Test
//    public void declarationAndAssignationShouldBeAddedToRegister() throws CompilationTimeException {
//        String variableName = "x";
//        String value = "1";
//
//        final TypeAssignationSyntaxBranch declaration = new TypeAssignationSyntaxBranch();
//        declaration.setTokenWrapper(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
//
//        final VariableSyntaxLeaf variable = new VariableSyntaxLeaf();
//        variable.setTokenWrapper(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, variableName));
//        declaration.addVariableSyntaxLeaf(variable);
//
//        final StringTypeSyntaxLeaf stringTypeSyntaxLeaf = new StringTypeSyntaxLeaf();
//        stringTypeSyntaxLeaf.setTokenWrapper(new TokenWrapper(Token.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
//        declaration.addStringTypeSyntaxLeaf(stringTypeSyntaxLeaf);
//
//        final ValueAssignationSyntaxBranch assig = new ValueAssignationSyntaxBranch();
//        assig.setTokenWrapper(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
//        assig.addTypeAsignationSyntaxTree(declaration);
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf.setTokenWrapper(new TokenWrapper(Token.NUMBER_LITERAL_TOKEN, 0, 0, 0, value));
//        assig.addLiteralSyntaxLeaf(literalSyntaxLeaf);
//
//        final VariableRegister variableRegister = new VariableRegister();
//
//        final Interpreter interpreter = new InterpreterImpl(variableRegister);
//
//        interpreter.interpret(assig);
//
//        assert variableRegister.contains(variableName);
//        assert variableRegister.get(variableName).get().getValue().equals("1.0");
//    }
//
//    @Test
//    public void assignationOfAnAlreadyDeclaredVariableShouldUpdateItsValue() throws CompilationTimeException {
//        String variableName = "x";
//        String newValue = "2.0";
//
//        final VariableRegister variableRegister = new VariableRegister();
//        final VariableInfo variable = new VariableInfo();
//        variable.setVariableName(variableName);
//        variable.setType(Token.NUMBER_TYPE_TOKEN);
//        variable.setValue("1");
//        variableRegister.addNewVariable(variable);
//
//        final AbstractSyntaxTree assignation = new ValueAssignationSyntaxBranch();
//        assignation.setTokenWrapper(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
//
//        final VariableSyntaxLeaf variable2 = new VariableSyntaxLeaf();
//        variable2.setTokenWrapper(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, variableName));
//        assignation.addVariableSyntaxLeaf(variable2);
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf.setTokenWrapper(new TokenWrapper(Token.NUMBER_LITERAL_TOKEN, 0, 0, 0, newValue));
//        assignation.addLiteralSyntaxLeaf(literalSyntaxLeaf);
//
//        final Interpreter interpreter = new InterpreterImpl(variableRegister);
//
//        interpreter.interpret(assignation);
//
//        assert variableRegister.get(variableName).isPresent();
//        assert variableRegister.get(variableName).get().getValue().equals(newValue);
//    }
//
//    @Test
//    public void stringConcatenationVisitor() throws CompilationTimeException {
//
//        final AbstractSyntaxTree root = new SumSubOperationSyntaxBranch();
//        root.setTokenWrapper(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf2 = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf2.setTokenWrapper(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "magosh"));
//        root.addLiteralSyntaxLeaf(literalSyntaxLeaf2);
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf.setTokenWrapper(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "oh"));
//        root.addLiteralSyntaxLeaf(literalSyntaxLeaf);
//
//        VariableRegister variableRegister = new VariableRegister();
//
//        StringOperationResultCalculatorVisitor visitor = new StringOperationResultCalculatorVisitor(variableRegister);
//
//        root.accept(visitor);
//
//        assert visitor.getResult().equals("ohmagosh");
//    }
//
//    @Test
//    public void stringConcatenationShouldBeAssignedToVariable() throws CompilationTimeException {
//        String variableName = "x";
//
//        // Add new variable to register
//        final VariableRegister variableRegister = new VariableRegister();
//        final VariableInfo variable = new VariableInfo();
//        variable.setVariableName(variableName);
//        variable.setType(Token.NUMBER_TYPE_TOKEN);
//        variable.setValue("1");
//        variableRegister.addNewVariable(variable);
//
//        final AbstractSyntaxTree assign = new ValueAssignationSyntaxBranch();
//        assign.setTokenWrapper(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
//
//        final VariableSyntaxLeaf var = new VariableSyntaxLeaf();
//        var.setTokenWrapper(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, variableName));
//        assign.addVariableSyntaxLeaf(var);
//
//        final AbstractSyntaxTree operationRoot = new SumSubOperationSyntaxBranch();
//        operationRoot.setTokenWrapper(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf2 = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf2.setTokenWrapper(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "magosh"));
//        operationRoot.addLiteralSyntaxLeaf(literalSyntaxLeaf2);
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf.setTokenWrapper(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "oh"));
//        operationRoot.addLiteralSyntaxLeaf(literalSyntaxLeaf);
//
//        assign.add(operationRoot);
//
//        StringOperationResultCalculatorVisitor visitor = new StringOperationResultCalculatorVisitor(variableRegister);
//
//        operationRoot.accept(visitor);
//
//        assert visitor.getResult().equals("ohmagosh");
//    }
//
//    @Test
//    public void multipleStringConcatenationVisitor() throws CompilationTimeException {
//
//        final AbstractSyntaxTree root = new SumSubOperationSyntaxBranch();
//        root.setTokenWrapper(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
//
//        final SumSubOperationSyntaxBranch left1 = new SumSubOperationSyntaxBranch();
//        left1.setTokenWrapper(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf2 = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf2.setTokenWrapper(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "-"));
//        left1.addLiteralSyntaxLeaf(literalSyntaxLeaf2);
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf.setTokenWrapper(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "oh"));
//        left1.addLiteralSyntaxLeaf(literalSyntaxLeaf);
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf3 = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf3.setTokenWrapper(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "magosh"));
//        root.addLiteralSyntaxLeaf(literalSyntaxLeaf3);
//
//        root.addSumSubOperationSyntaxTree(left1);
//
//        VariableRegister variableRegister = new VariableRegister();
//
//        StringOperationResultCalculatorVisitor visitor = new StringOperationResultCalculatorVisitor(variableRegister);
//
//        root.accept(visitor);
//
//        assert visitor.getResult().equals("oh-magosh");
//    }
//
//    @Test
//    public void multipleNumberOperationAssignation() throws CompilationTimeException {
//        String variableName = "x";
//
//        // Add new variable to register
//        final VariableRegister variableRegister = new VariableRegister();
//        final VariableInfo variable = new VariableInfo();
//        variable.setVariableName(variableName);
//        variable.setType(Token.NUMBER_TYPE_TOKEN);
//        variable.setValue("1");
//        variableRegister.addNewVariable(variable);
//
//        final AbstractSyntaxTree assign = new ValueAssignationSyntaxBranch();
//        assign.setTokenWrapper(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
//
//        final VariableSyntaxLeaf var = new VariableSyntaxLeaf();
//        var.setTokenWrapper(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, variableName));
//        assign.addVariableSyntaxLeaf(var);
//
//        final AbstractSyntaxTree operationRoot = new SumSubOperationSyntaxBranch();
//        operationRoot.setTokenWrapper(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
//
//        final MultDivOperationSyntaxBranch left1 = new MultDivOperationSyntaxBranch();
//        left1.setTokenWrapper(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf2 = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf2.setTokenWrapper(new TokenWrapper(Token.NUMBER_LITERAL_TOKEN, 0, 0, 0, "1"));
//        left1.addLiteralSyntaxLeaf(literalSyntaxLeaf2);
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf.setTokenWrapper(new TokenWrapper(Token.NUMBER_LITERAL_TOKEN, 0, 0, 0, "2"));
//        left1.addLiteralSyntaxLeaf(literalSyntaxLeaf);
//
//        final LiteralSyntaxLeaf literalSyntaxLeaf3 = new LiteralSyntaxLeaf();
//        literalSyntaxLeaf3.setTokenWrapper(new TokenWrapper(Token.NUMBER_LITERAL_TOKEN, 0, 0, 0, "3"));
//        operationRoot.addLiteralSyntaxLeaf(literalSyntaxLeaf3);
//
//        operationRoot.addMultDivOperationSyntaxTree(left1);
//        assign.add(operationRoot);
//
//        final Interpreter interpreter = new InterpreterImpl(variableRegister);
//
//        interpreter.interpret(assign);
//
//        assert variableRegister.get(variableName).get().getValue().equals("5.0");
//    }
//}
