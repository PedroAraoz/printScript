package edu.austral.ingsis;

import java.util.HashMap;
import java.util.List;

public class ASTFactory {
  
  public AbstractSyntaxTree build(List<TokenWrapper> tokenWrapperList) {

    final AbstractSyntaxTree abstractSyntaxTree;
    // First we check if the sentence ends with a ;
    if (!tokenWrapperList.get(tokenWrapperList.size() - 1).getName().equals(Token.SEMICOLON_TOKEN.getName())) {
      //Syntax Error
    } else {



    }

    return null;
  }
  
  public AbstractSyntaxTree rec(List<TokenWrapper> tokens) {
    if (tokens.stream().anyMatch(e -> e.getToken().equals(Token.VALUE_ASSIGNATION_TOKEN))) {
      for (int i = 0; i < tokens.size(); i++) {
        TokenWrapper t = tokens.get(i);
        if (t.equals(Token.VALUE_ASSIGNATION_TOKEN)) {
          return new AssignationSyntaxBranch(
                  (DeclaVariable) rec(tokens.subList(0, i)),
                  (Operand) rec(tokens.subList(i, tokens.size() - 1)), t);
        }
      }
//    } else if (tokens.stream().anyMatch(e -> e.getToken().equals(Token.Type))) {
//
//    }
    }
    return null;
  }
}
