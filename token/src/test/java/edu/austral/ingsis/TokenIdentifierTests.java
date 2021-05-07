package edu.austral.ingsis;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TokenIdentifierTests {

  @Test
  public void test001_WhenGetAllTokensTestShouldReturnThem() {
    List<TokenIdentifier> list = TokenIdentifier.getAllTokens();
    Assert.assertFalse(list.isEmpty());
  }

  @Test
  public void test002_WhenGettersShouldReturnCorrectInfo() {
    TokenIdentifier tokenIdentifier = TokenIdentifier.LET_TOKEN;
    Assert.assertEquals(TokenName.LET, tokenIdentifier.getName());
    Assert.assertEquals("let", tokenIdentifier.getRegex().toString());
    Assert.assertEquals(TokenName.LET.toString(), tokenIdentifier.toString());
  }

  @Test
  public void test003_WhenThePatternMatchesTokenVerifyShouldReturnTrue() {
    final TokenIdentifier t1 = TokenIdentifier.NUMBER_LITERAL_TOKEN;
    final TokenIdentifier t2 = TokenIdentifier.SEMICOLON_TOKEN;
    final TokenIdentifier t3 = TokenIdentifier.LET_TOKEN;
    final String s1 = "123.123";
    final String s2 = ";";
    final String s3 = "let";

    Assert.assertTrue(t1.verify(s1));
    Assert.assertTrue(t2.verify(s2));
    Assert.assertTrue(t3.verify(s3));
  }

  @Test
  public void test004_WhenThePatternDoesNotMatchTokenVerifyShouldReturnFalse() {
    final TokenIdentifier t1 = TokenIdentifier.STRING_TYPE_TOKEN;
    final TokenIdentifier t2 = TokenIdentifier.LET_TOKEN;
    final TokenIdentifier t3 = TokenIdentifier.DIV_OPERATION_TOKEN;
    final String s1 = "/";
    final String s2 = ";";
    final String s3 = "let";

    Assert.assertFalse(t1.verify(s1));
    Assert.assertFalse(t2.verify(s2));
    Assert.assertFalse(t3.verify(s3));
  }

  @Test
  public void test005_TokenWrapperGettersShouldWork() {
    final TokenIdentifier variableTokenIdentifier = TokenIdentifier.VARIABLE_TOKEN;
    final int line = 1;
    final int startPos = 0;
    final int endPos = 3;
    final String value = "asd";
    final Token t = new Token(variableTokenIdentifier, line, startPos, endPos, value);
    Assert.assertEquals(variableTokenIdentifier, t.getTokenIdentifier());
    Assert.assertEquals(variableTokenIdentifier.getName(), t.getName());
    Assert.assertEquals(variableTokenIdentifier.toString(), t.toString());
    Assert.assertEquals(variableTokenIdentifier.getRegex(), t.getRegex());
    Assert.assertEquals(line, t.getLine());
    Assert.assertEquals(startPos, t.getStartPos());
    Assert.assertEquals(endPos, t.getEndPos());
    Assert.assertEquals(value, t.getValue());
  }

  @Test
  public void test006_WhenThePatternMatchesTokenWrapperVerifyShouldReturnTrue() {
    final TokenIdentifier t1 = TokenIdentifier.NUMBER_LITERAL_TOKEN;
    final TokenIdentifier t2 = TokenIdentifier.SEMICOLON_TOKEN;
    final TokenIdentifier t3 = TokenIdentifier.LET_TOKEN;
    final Token tw1 = new Token(t1, 0, 0, 0, "");
    final Token tw2 = new Token(t2, 0, 0, 0, "");
    final Token tw3 = new Token(t3, 0, 0, 0, "");
    final String s1 = "123.123";
    final String s2 = ";";
    final String s3 = "let";

    Assert.assertTrue(tw1.verify(s1));
    Assert.assertTrue(tw2.verify(s2));
    Assert.assertTrue(tw3.verify(s3));
  }

  @Test
  public void test007_WhenThePatternDoesNotMatchTokenWrapperVerifyShouldReturnFalse() {
    final TokenIdentifier t1 = TokenIdentifier.STRING_TYPE_TOKEN;
    final TokenIdentifier t2 = TokenIdentifier.LET_TOKEN;
    final TokenIdentifier t3 = TokenIdentifier.DIV_OPERATION_TOKEN;
    final Token tw1 = new Token(t1, 0, 0, 0, "");
    final Token tw2 = new Token(t1, 0, 0, 0, "");
    final Token tw3 = new Token(t1, 0, 0, 0, "");
    final String s1 = "/";
    final String s2 = ";";
    final String s3 = "let";

    Assert.assertFalse(tw1.verify(s1));
    Assert.assertFalse(tw2.verify(s2));
    Assert.assertFalse(tw3.verify(s3));
  }

  @Test
  public void test008_WhenGetTokenOnTupleShouldReturnIt() {
    final Tuple tuple = new Tuple(TokenIdentifier.LET_TOKEN, "string");
    Assert.assertEquals(TokenIdentifier.LET_TOKEN, tuple.getToken());
  }

  @Test
  public void test009_WhenGetStringOnTupleShouldReturnItWithoutQuotes() {
    final Tuple tuple = new Tuple(TokenIdentifier.LET_TOKEN, "'string'");
    Assert.assertEquals("string", tuple.getString());
  }
}
