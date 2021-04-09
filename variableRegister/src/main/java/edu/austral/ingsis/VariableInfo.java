package edu.austral.ingsis;

public class VariableInfo {

    private String variableName;
    private Token type;
    private String value = "";

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public Token getType() {
        return type;
    }

    public void setType(Token type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
