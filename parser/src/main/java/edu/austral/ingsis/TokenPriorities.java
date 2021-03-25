package edu.austral.ingsis;

import java.util.HashMap;

public class TokenPriorities {
    
    public static HashMap<Token, Integer> getPriorityMap() {

        final HashMap<Token, Integer> priorityMap = new HashMap<>();
        
        priorityMap.put(Token.VALUE_ASSIGNATION_TOKEN, 0);
        priorityMap.put(Token.TYPE_ASSIGNATION_TOKEN, 1);
        priorityMap.put(Token.SUM_OPERATION_TOKEN, 2);
        priorityMap.put(Token.SUB_OPERATION_TOKEN, 2);
        priorityMap.put(Token.MULT_OPERATION_TOKEN, 3);
        priorityMap.put(Token.DIV_OPERATION_TOKEN, 3);
        priorityMap.put(Token.NUMBER_TYPE_TOKEN, 4);
        priorityMap.put(Token.STRING_TYPE_TOKEN, 4);
        priorityMap.put(Token.LITERAL_TOKEN, 5);
        priorityMap.put(Token.LET_TOKEN, 5);
        priorityMap.put(Token.SEMICOLON_TOKEN, 6);

        return priorityMap;
    }
}
