package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

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
  
  public void assignValueToVariable(Token variable, Token value) throws CompilationTimeException {
    for (VariableInfo vi : variables) {
      if (vi.getVariableName().equals(variable.getValue())) {
        if (sameType(vi.getType(), (value.getTokenIdentifier()))) {
          // everything ok
          vi.setValue(value.getValue());
          return;
        } else {
          // var.type != value.type osea estan haciendo x: string = 123;
          throw interpreterError(
                  "TODO ADD FILE", variable.getLine(), variable.getStartPos(), value.getStartPos(),
                  "Variable and value do not match"); //todo add file
        }
      }
    }
    // no encontro ninguna variable con ese nombre
    throw interpreterError(
            "TODO ADD FILE", variable.getLine(), variable.getStartPos(), variable.getStartPos(),
            "Variable not initialized"); //todo add file
  }
  
  private boolean sameType(TokenIdentifier a, TokenIdentifier b) {
    return a.equals(b) ||
    (a.equals(TokenIdentifier.STRING_LITERAL_TOKEN) && b.equals(TokenIdentifier.STRING_TYPE_TOKEN)) ||
    (b.equals(TokenIdentifier.STRING_LITERAL_TOKEN) && a.equals(TokenIdentifier.STRING_TYPE_TOKEN)) ||
    (a.equals(TokenIdentifier.NUMBER_LITERAL_TOKEN) && b.equals(TokenIdentifier.NUMBER_TYPE_TOKEN)) ||
    (b.equals(TokenIdentifier.NUMBER_LITERAL_TOKEN) && a.equals(TokenIdentifier.NUMBER_TYPE_TOKEN));
  }
  
  private CompilationTimeException interpreterError(String file, int line, int from, int to, String text) {
    final String message = "On File: " + file  + "\n" +
            "line: " + line + "\n" +
            "from: " + from + " to: " + to + "\n" +
            "message: " + text;
    return new CompilationTimeException(message);
  }
}
