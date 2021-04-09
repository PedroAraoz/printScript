package edu.austral.ingsis.operation;

public class SubOperation implements Operation{
    @Override
    public double operate(double operand1, double operand2) {
        return operand1-operand2;
    }
}
