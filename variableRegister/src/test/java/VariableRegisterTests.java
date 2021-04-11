import edu.austral.ingsis.Token;
import edu.austral.ingsis.VariableInfo;
import edu.austral.ingsis.VariableRegister;
import org.junit.Test;

public class VariableRegisterTests {

    @Test
    public void whenVariableIsAddedVariableRegisterShouldContainIt() {

        final VariableRegister variableRegister = new VariableRegister();

        final VariableInfo variable = new VariableInfo();
        variable.setVariableName("x");
        variable.setValue("0");
        variable.setType(Token.NUMBER_TYPE_TOKEN);

        variableRegister.addNewVariable(variable);

        assert variableRegister.contains(variable.getVariableName());
    }
}
