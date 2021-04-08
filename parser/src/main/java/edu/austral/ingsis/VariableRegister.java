package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;

public class VariableRegister {

    List<VariableInfo> variables = new ArrayList<>();

    public boolean contains(String variableName) {
        return variables.stream().anyMatch(v -> v.getVariableName().equals(variableName));
    }
}
