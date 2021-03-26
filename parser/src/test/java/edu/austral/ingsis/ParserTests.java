package edu.austral.ingsis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTests {
  
  @Test
  public void asd() {
  
    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new TokenWrapper(Token.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }
}
