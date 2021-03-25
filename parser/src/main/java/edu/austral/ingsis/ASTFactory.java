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

    return abstractSyntaxTree;
  }

  private AbstractSyntaxTree findRoot(List<TokenWrapper> tokenWrapperList) {

    HashMap<Token, Integer> priorityMap = TokenPriorities.getPriorityMap();

    tokenWrapperList.stream().map(e -> priorityMap.get(e.getToken()));
  }
}
