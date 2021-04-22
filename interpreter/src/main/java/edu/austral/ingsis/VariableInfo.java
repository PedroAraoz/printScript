package edu.austral.ingsis;

public class VariableInfo {

    private String variableName;
    private TokenIdentifier type;
    private String value = "";
    private boolean con = false;

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public TokenIdentifier getType() {
        return type;
    }

    public void setType(TokenIdentifier type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCon(boolean con) {
        this.con = con;
    }

    public boolean isConst() {
        return con;
    }
}
