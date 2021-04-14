package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VariableRegister {

    private List<VariableInfo> variables = new ArrayList<>();

    public boolean contains(String variableName) {
        return variables.stream().anyMatch(v -> v.getVariableName().equals(variableName));
    }

//    public void addNewVariable(VariableInfo newVariable) {
//        variables.add(newVariable);
//    }

    public void addNewVariable(String variableName, TokenIdentifier type) {
        VariableInfo variableInfo = new VariableInfo();

        variableInfo.setVariableName(variableName);
        variableInfo.setType(type);

        // TODO check si ya existe
        variables.add(variableInfo);
    }

    public Optional<VariableInfo> get(String variable) {
        return variables.stream().filter(v -> v.getVariableName().equals(variable)).findFirst();
    }

    // TODO que explote si no esta
    public void assignValueToVariable(String name, String value) {
        for (VariableInfo variable : variables) {
            if (variable.getVariableName().equals(name))
                variable.setValue(value);
        }
    }
}
