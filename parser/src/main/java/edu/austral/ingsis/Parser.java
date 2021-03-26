package edu.austral.ingsis;

import java.util.List;

public interface Parser {

    AbstractSyntaxTree analyseSintactically(List<TokenWrapper> tokenWrapperList);

    boolean analyseSemantically(AbstractSyntaxTree ast);
}
