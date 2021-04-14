import edu.austral.ingsis.CodeLine;
import edu.austral.ingsis.LexerImpl;
import edu.austral.ingsis.TokenIdentifier;
import edu.austral.ingsis.Token;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LexerTests {

  @Test
  public void DeclarationAsignationOperationTest() {
    final List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("let x: number = 2 + 3", 0));
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.letTokenIdentifier, 0, 0, 3, "let"));
    expected.add(new Token(TokenIdentifier.variableTokenIdentifier, 0, 3, 4, "x"));
    expected.add(new Token(TokenIdentifier.typeAssignationTokenIdentifier, 0, 4, 5, ":"));
    expected.add(new Token(TokenIdentifier.numberTypeTokenIdentifier, 0, 5, 11, "number"));
    expected.add(new Token(TokenIdentifier.valueAssignationTokenIdentifier, 0, 11, 12, "="));
    expected.add(new Token(TokenIdentifier.numberLiteralTokenIdentifier, 0, 12, 13, "2"));
    expected.add(new Token(TokenIdentifier.sumOperationTokenIdentifier, 0, 13, 14, "+"));
    expected.add(new Token(TokenIdentifier.numberLiteralTokenIdentifier, 0, 14, 15, "3"));
    LexerImpl lexer = new LexerImpl();
    final List<Token> tokens = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
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
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.letTokenIdentifier, 0, 0, 0, "let"));
    expected.add(new Token(TokenIdentifier.variableTokenIdentifier, 0, 0, 0, "x"));
    expected.add(new Token(TokenIdentifier.typeAssignationTokenIdentifier, 0, 0, 0, ":"));
    expected.add(new Token(TokenIdentifier.numberTypeTokenIdentifier, 0, 0, 0, "number"));
    expected.add(new Token(TokenIdentifier.valueAssignationTokenIdentifier, 0, 0, 0, "="));
    expected.add(new Token(TokenIdentifier.numberLiteralTokenIdentifier, 0, 0, 0, "2222"));
    expected.add(new Token(TokenIdentifier.semicolonTokenIdentifier, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    final List<Token> tokens = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
      assertEquals(e.toString(), a.toString());
      assertEquals(e.getLine(), a.getLine());
      assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void StringDoubleQuoteLiteralTest() {
    List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("let x: string = \"hola\";", 0));
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.letTokenIdentifier, 0, 0, 0, "let"));
    expected.add(new Token(TokenIdentifier.variableTokenIdentifier, 0, 0, 0, "x"));
    expected.add(new Token(TokenIdentifier.typeAssignationTokenIdentifier, 0, 0, 0, ":"));
    expected.add(new Token(TokenIdentifier.stringTypeTokenIdentifier, 0, 0, 0, "string"));
    expected.add(new Token(TokenIdentifier.valueAssignationTokenIdentifier, 0, 0, 0, "="));
    expected.add(new Token(TokenIdentifier.stringLiteralTokenIdentifier, 0, 0, 0, "hola"));
    expected.add(new Token(TokenIdentifier.semicolonTokenIdentifier, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    final List<Token> tokens = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
      assertEquals(e.toString(), a.toString());
      assertEquals(e.getLine(), a.getLine());
      assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void StringSimpleQuoteLiteralTest() {
    List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("let x: string = 'hola';", 0));
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.letTokenIdentifier, 0, 0, 0, "let"));
    expected.add(new Token(TokenIdentifier.variableTokenIdentifier, 0, 0, 0, "x"));
    expected.add(new Token(TokenIdentifier.typeAssignationTokenIdentifier, 0, 0, 0, ":"));
    expected.add(new Token(TokenIdentifier.stringTypeTokenIdentifier, 0, 0, 0, "string"));
    expected.add(new Token(TokenIdentifier.valueAssignationTokenIdentifier, 0, 0, 0, "="));
    expected.add(new Token(TokenIdentifier.stringLiteralTokenIdentifier, 0, 0, 0, "hola"));
    expected.add(new Token(TokenIdentifier.semicolonTokenIdentifier, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    final List<Token> tokens = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
      assertEquals(e.toString(), a.toString());
      assertEquals(e.getLine(), a.getLine());
      assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void parenthesisTest() {
    List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("( x: string = 'hola' );", 0));
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.leftParenthesisIdentifier, 0, 0, 0, "("));
    expected.add(new Token(TokenIdentifier.variableTokenIdentifier, 0, 0, 0, "x"));
    expected.add(new Token(TokenIdentifier.typeAssignationTokenIdentifier, 0, 0, 0, ":"));
    expected.add(new Token(TokenIdentifier.stringTypeTokenIdentifier, 0, 0, 0, "string"));
    expected.add(new Token(TokenIdentifier.valueAssignationTokenIdentifier, 0, 0, 0, "="));
    expected.add(new Token(TokenIdentifier.stringLiteralTokenIdentifier, 0, 0, 0, "hola"));
    expected.add(new Token(TokenIdentifier.rightParenthesisIdentifier, 0, 0, 0, ")"));
    expected.add(new Token(TokenIdentifier.semicolonTokenIdentifier, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    final List<Token> tokens = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
      assertEquals(e.toString(), a.toString());
      assertEquals(e.getLine(), a.getLine());
      assertEquals(e.getValue(), a.getValue());
    }
  }

  @Test
  public void printLnTest() {
    List<CodeLine> codeLineList = new ArrayList<>();
    codeLineList.add(new CodeLine("printLn('hola');", 0));
    final List<Token> expected = new ArrayList<>();
    expected.add(new Token(TokenIdentifier.printLnTokenIdentifier, 0, 0, 0, "printLn"));
    expected.add(new Token(TokenIdentifier.leftParenthesisIdentifier, 0, 0, 0, "("));
    expected.add(new Token(TokenIdentifier.stringLiteralTokenIdentifier, 0, 0, 0, "hola"));
    expected.add(new Token(TokenIdentifier.rightParenthesisIdentifier, 0, 0, 0, ")"));
    expected.add(new Token(TokenIdentifier.semicolonTokenIdentifier, 0, 0, 0, ";"));
    LexerImpl lexer = new LexerImpl();
    final List<Token> tokens = lexer.analyseLexically(codeLineList.get(0));

    for (int i = 0; i < expected.size(); i++) {
      final Token e = expected.get(i);
      final Token a = tokens.get(i);
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
