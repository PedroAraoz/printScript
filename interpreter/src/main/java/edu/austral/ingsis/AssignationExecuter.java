package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;

public class AssignationExecuter implements Executer {

    private final VariableRegister variableRegister;

    public AssignationExecuter(VariableRegister variableRegister) {
        this.variableRegister = variableRegister;
    }

    @Override
    public List<String> execute(AbstractSyntaxTree ast) {
        List<String> logs = new ArrayList<>();
        ValueAssignationFinderVisitor valueAssignationFinderVisitor = new ValueAssignationFinderVisitor();
        ast.accept(valueAssignationFinderVisitor);

        if (valueAssignationFinderVisitor.getValueAssignation().isPresent()) {
            VariableFinderVisitor variableFinderVisitor = new VariableFinderVisitor();
            ast.accept(variableFinderVisitor);

            // Solve assignation value
            assignValue(logs, variableFinderVisitor.getVariable().get().getValue(), ast);
        }

        return logs;
    }

    private void assignValue(List<String> logs, String variableName, AbstractSyntaxTree ast) {
        AssignationLiteralTypeVisitor assignationLiteralTypeVisitor = new AssignationLiteralTypeVisitor();
        ast.accept(assignationLiteralTypeVisitor);

        if (assignationLiteralTypeVisitor.getType().equals(Token.NUMBER_LITERAL_TOKEN)) {
            // Calculate result
            double result = calculateNumberResult(ast);

            // Assign value
            variableRegister.updateVariable(variableName, String.valueOf(result));

            // Add logs
            logs.add("Value " + result + " was assigned to variable " + variableName);

        } else if (assignationLiteralTypeVisitor.getType().equals(Token.STRING_LITERAL_TOKEN)) {
            // Calculate result
            String result = calculateStringResult(ast);

            // Assign value
            variableRegister.updateVariable(variableName, result);

            // Add logs
            logs.add("Value " + result + " was assigned to variable " + variableName);
        }
    }

    private double calculateNumberResult(AbstractSyntaxTree ast) {
        NumberOperationResultCalculatorVisitor numberOperationResultCalculatorVisitor = new NumberOperationResultCalculatorVisitor(variableRegister);
        ast.accept(numberOperationResultCalculatorVisitor);

        return numberOperationResultCalculatorVisitor.getResult();
    }

    private String calculateStringResult(AbstractSyntaxTree ast) {
        StringOperationResultCalculatorVisitor stringOperationResultCalculatorVisitor = new StringOperationResultCalculatorVisitor(variableRegister);
        ast.accept(stringOperationResultCalculatorVisitor);

        return stringOperationResultCalculatorVisitor.getResult();
    }
}
