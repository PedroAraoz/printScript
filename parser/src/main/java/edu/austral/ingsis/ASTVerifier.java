package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import edu.austral.ingsis.validator.*;

import java.util.ArrayList;
import java.util.List;

public class ASTVerifier {

    private final VariableRegister register;
    private final List<Validator> validators = new ArrayList<>();

    public ASTVerifier(VariableRegister register) {
        this.register = register;


        validators.add(new DeclarationValidator(register));
        validators.add(new AssignationVariableExistsValidator(register));
        validators.add(new AssignationTypeValidator(register));
    }

    public void verify(AbstractSyntaxTree abstractSyntaxTree) throws CompilationTimeException {
        for (Validator validator : validators) {
            validator.validate(abstractSyntaxTree);
        }
    }

    /*****
     *  Cosas para chequear:
     *
     * # para estas vamos a necesitar una estructura para guardar las variables que ya tenemos asi podemos ir a buscarlas
     *
     *  - Que las variables no se inicialicen dos veces
     *  - QUe a las variables solo les puedas asignar datos del tipo que pusiste
     *  - Que las variables que uses esten declaradas previamente
     *
     */
}
