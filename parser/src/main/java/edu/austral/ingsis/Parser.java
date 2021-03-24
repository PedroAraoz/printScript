package edu.austral.ingsis;

import java.util.List;

public interface Parser {

    public AbstractSyntaxTree analyseSintactically(List<TokenWrapper> tokenWrapperList);

    public boolean analyseSemantically(AbstractSyntaxTree ast);
}
