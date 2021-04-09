package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VariableRegister {

    List<VariableInfo> variables = new ArrayList<>();

    public boolean contains(String variableName) {
        return variables.stream().anyMatch(v -> v.getVariableName().equals(variableName));
    }

    public void addNewVariable(VariableInfo newVariable) {
        variables.add(newVariable);
    }

    public Optional<VariableInfo> get(String variable) {
        return variables.stream().filter(v -> v.getVariableName().equals(variable)).findFirst();
    }
}
