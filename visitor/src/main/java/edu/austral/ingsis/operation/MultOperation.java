package edu.austral.ingsis.operation;

public class MultOperation implements Operation{
    @Override
    public double operate(double operand1, double operand2) {
        return operand1*operand2;
    }
}
