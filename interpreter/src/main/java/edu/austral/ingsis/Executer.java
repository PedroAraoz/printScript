package edu.austral.ingsis;

import java.util.List;

public interface Executer {

    List<String> execute(AbstractSyntaxTree ast);
}
