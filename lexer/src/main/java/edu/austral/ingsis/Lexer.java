package edu.austral.ingsis;

import java.util.List;

public interface Lexer {
    List<TokenWrapper> analyseLexically(CodeLine line);
}
