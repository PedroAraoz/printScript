import edu.austral.ingsis.CodeLine;
import edu.austral.ingsis.LexerImpl;
import edu.austral.ingsis.Token;
import edu.austral.ingsis.TokenWrapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LexerTests {

  @Test
  public void DeclarationAsignationOperationTest() {
    final List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("let x: number = 2 + 3", 0));
    final List<TokenWrapper> expected = new ArrayList<>();
    expected.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 3, "let"));
    expected.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 3, 4, "x"));
    expected.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 4, 5, ":"));
    expected.add(new TokenWrapper(Token.NUMBER_TYPE_TOKEN, 0, 5, 11, "number"));
    expected.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 11, 12, "="));
    expected.add(new TokenWrapper(Token.NUMBER_LITERAL_TOKEN, 0, 12, 13, "2"));
    expected.add(new TokenWrapper(Token.SUM_OPERATION_TOKEN, 0, 13, 14, "+"));
    expected.add(new TokenWrapper(Token.NUMBER_LITERAL_TOKEN, 0, 14, 15, "3"));
    LexerImpl lexer = new LexerImpl();
    final List<TokenWrapper> tokenWrappers = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final TokenWrapper e = expected.get(i);
      final TokenWrapper a = tokenWrappers.get(i);
      assertEquals(e.toString(), a.toString());
      assertEquals(e.getLine(), a.getLine());
      assertEquals(e.getValue(), a.getValue());
      assertEquals(e.getStartPos(), a.getStartPos());
      assertEquals(e.getEndPos(), a.getEndPos());
    }
  }

  @Test
  public void NumberLiteralTest() {
    List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("let x: number = 2222;", 0));
    final List<TokenWrapper> expected = new ArrayList<>();
    expected.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    expected.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    expected.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    expected.add(new TokenWrapper(Token.NUMBER_TYPE_TOKEN, 0, 0, 0, "number"));
    expected.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    expected.add(new TokenWrapper(Token.NUMBER_LITERAL_TOKEN, 0, 0, 0, "2222"));
    expected.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    final List<TokenWrapper> tokenWrappers = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final TokenWrapper e = expected.get(i);
      final TokenWrapper a = tokenWrappers.get(i);
      assertEquals(e.toString(), a.toString());
      assertEquals(e.getLine(), a.getLine());
      assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void StringDoubleQuoteLiteralTest() {
    List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("let x: string = \"hola\";", 0));
    final List<TokenWrapper> expected = new ArrayList<>();
    expected.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    expected.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    expected.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    expected.add(new TokenWrapper(Token.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
    expected.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    expected.add(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "hola"));
    expected.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    final List<TokenWrapper> tokenWrappers = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final TokenWrapper e = expected.get(i);
      final TokenWrapper a = tokenWrappers.get(i);
      assertEquals(e.toString(), a.toString());
      assertEquals(e.getLine(), a.getLine());
      assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void StringSimpleQuoteLiteralTest() {
    List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("let x: string = 'hola';", 0));
    final List<TokenWrapper> expected = new ArrayList<>();
    expected.add(new TokenWrapper(Token.LET_TOKEN, 0, 0, 0, "let"));
    expected.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "x"));
    expected.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
    expected.add(new TokenWrapper(Token.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
    expected.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
    expected.add(new TokenWrapper(Token.STRING_LITERAL_TOKEN, 0, 0, 0, "hola"));
    expected.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    final List<TokenWrapper> tokenWrappers = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final TokenWrapper e = expected.get(i);
      final TokenWrapper a = tokenWrappers.get(i);
      assertEquals(e.toString(), a.toString());
      assertEquals(e.getLine(), a.getLine());
      assertEquals(e.getValue(), a.getValue());
    }
  }

  //  @Test
  //  public void aWeirdCase() {
  //    List<CodeLine> codeLineList = new ArrayList<>();
  //    codeLineList.add(new CodeLine("x; string asd:=", 0));
  //    final List<TokenWrapper> expected = new ArrayList<>();
  //    expected.add(new TokenWrapper(Token.LITERAL_TOKEN, 0, 0, 0, "'x'"));
  //    expected.add(new TokenWrapper(Token.SEMICOLON_TOKEN, 0, 0, 0, ";"));
  //    expected.add(new TokenWrapper(Token.STRING_TYPE_TOKEN, 0, 0, 0, "string"));
  //    expected.add(new TokenWrapper(Token.VARIABLE_TOKEN, 0, 0, 0, "asd"));
  //    expected.add(new TokenWrapper(Token.TYPE_ASSIGNATION_TOKEN, 0, 0, 0, ":"));
  //    expected.add(new TokenWrapper(Token.VALUE_ASSIGNATION_TOKEN, 0, 0, 0, "="));
  //    LexerImpl lexer = new LexerImpl();
  //    final List<TokenWrapper> tokenWrappers = lexer.analyseLexically(codeLineList.get(0));
  //
  //    for (int i = 0; i < expected.size(); i++) {
  //      final TokenWrapper e = expected.get(i);
  //      final TokenWrapper a = tokenWrappers.get(i);
  //      assertEquals(e.toString(), a.toString());
  //      assertEquals(e.getLine(), a.getLine());
  //      assertEquals(e.getValue(), a.getValue());
  //    }
  //  }
}
