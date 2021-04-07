package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTests {

  @Test
  public void testDeclaAsignMult() throws CompilationTimeException {

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

  @Test
  public void TwoOperationsSum() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new TokenWrapper(Token.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "12"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "13"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testDeclaAsignSum() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new TokenWrapper(Token.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testDeclaString() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new TokenWrapper(Token.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void testDeclaAsignString() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new TokenWrapper(Token.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "hola"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void asigVarMult() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "12"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void SumMult() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "2"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "3"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void emptyWithSum() {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 22, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 22, 0, 0, "12"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 22, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree;
    try {
      abstractSyntaxTree = parser.analyseSintactically(list);
    } catch (CompilationTimeException e) {
      System.out.println(e.getMessage());
      assert true;
    }
  }

  @Test
  public void emptyWithMult() {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 22, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 22, 0, 0, "12"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 22, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree;
    try {
      abstractSyntaxTree = parser.analyseSintactically(list);
    } catch (CompilationTimeException e) {
      assert true;
    }
    System.out.println("ASD");
  }

  @Test
  public void emptyWithValueAsign() {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "12"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree;
    try {
      abstractSyntaxTree = parser.analyseSintactically(list);
    } catch (CompilationTimeException e) {
      assert true;
    }
    System.out.println("ASD");
  }

  @Test
  public void emptyWithTypeAsign() {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new TokenWrapper(Token.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree;
    try {
      abstractSyntaxTree = parser.analyseSintactically(list);
    } catch (CompilationTimeException e) {
      assert true;
    }
    System.out.println("ASD");
  }

  @Test
  public void multipleOperationsSum() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new TokenWrapper(Token.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "12"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "13"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "14"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "15"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "16"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void multipleOperationsMult() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    list.add(new TokenWrapper(Token.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "12"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "13"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "14"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "15"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "16"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void sumWithVariables() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void multWithVariables() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "11"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void multSumMix() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "y"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "2"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }

  @Test
  public void sumMultMix() throws CompilationTimeException {

    final Parser parser = new ParserImpl();
    final List<TokenWrapper> list = new ArrayList<>();
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "1"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    list.add(new TokenWrapper(Token.MULT_OPERATION_TOKEN, 0, 0, 0, "*"));
    list.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "y"));
    list.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 0, 0, "+"));
    list.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "2"));
    list.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(list);
    System.out.println("ASD");
  }
}
