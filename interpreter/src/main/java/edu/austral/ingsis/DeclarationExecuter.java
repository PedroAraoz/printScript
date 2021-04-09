package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;

public class DeclarationExecuter implements Executer {

    private final VariableRegister variableRegister;

    public DeclarationExecuter(VariableRegister variableRegister) {
        this.variableRegister = variableRegister;
    }

    @Override
    public List<String> execute(AbstractSyntaxTree ast) {
        List<String> logs = new ArrayList<>();
        TypeAssignationFinderVisitor typeAssignationFinderVisitor = new TypeAssignationFinderVisitor();
        ast.accept(typeAssignationFinderVisitor);

        // If there is a declaration, add the variable to the register
        if (typeAssignationFinderVisitor.getTypeAssignation().isPresent()) {
            // Add variable to register

            VariableFinderVisitor variableFinderVisitor = new VariableFinderVisitor();
            ast.accept(variableFinderVisitor);
            TokenWrapper tokenWrapper = variableFinderVisitor.getVariable().get();

            VariableInfo variableInfo = new VariableInfo();
            variableInfo.setVariableName(tokenWrapper.getValue());
            variableInfo.setType(tokenWrapper.getToken());

            if (typeAssignationFinderVisitor.getTypeAssignation().get().right.getTokenWrapper().getToken().equals(Token.NUMBER_TYPE_TOKEN))
                variableInfo.setValue("0");

            variableRegister.addNewVariable(variableInfo);

            // Agregar log que indique lo que se hizo

            logs.add("Declaration for variable " + tokenWrapper.getValue() + " was found");
        }

        return logs;
    }
}
