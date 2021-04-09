package edu.austral.ingsis;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TokenTests {

  @Test
  public void test001_WhenGetAllTokensTestShouldReturnThem() {
    List<Token> list = Token.getAllTokens();
    Assert.assertFalse(list.isEmpty());
  }

  @Test
  public void test002_WhenGettersShouldReturnCorrectInfo() {
    Token token = Token.LET_TOKEN;
    Assert.assertEquals(TokenName.LET, token.getName());
    Assert.assertEquals("let", token.getRegex().toString());
    Assert.assertEquals(TokenName.LET.toString(), token.toString());
  }
  
  @Test
  public void test003_WhenThePatternMatchesTokenVerifyShouldReturnTrue() {
    final Token t1 = Token.NUMBER_LITERAL_TOKEN;
    final Token t2 = Token.SEMICOLON_TOKEN;
    final Token t3 = Token.LET_TOKEN;
    final String s1 = "123.123";
    final String s2 = ";";
    final String s3 = "let";
    
    Assert.assertTrue(t1.verify(s1));
    Assert.assertTrue(t2.verify(s2));
    Assert.assertTrue(t3.verify(s3));
  }
  
  @Test
  public void test004_WhenThePatternDoesNotMatchTokenVerifyShouldReturnFalse() {
    final Token t1 = Token.STRING_TYPE_TOKEN;
    final Token t2 = Token.LET_TOKEN;
    final Token t3 = Token.DIV_OPERATION_TOKEN;
    final String s1 = "/";
    final String s2 = ";";
    final String s3 = "let";
    
    Assert.assertFalse(t1.verify(s1));
    Assert.assertFalse(t2.verify(s2));
    Assert.assertFalse(t3.verify(s3));
  }
  
  @Test
  public void test005_TokenWrapperGettersShouldWork() {
    final Token variableToken = Token.VARIABLE_TOKEN;
    final int line = 1;
    final int startPos = 0;
    final int endPos = 3;
    final String value = "asd";
    final TokenWrapper t = new TokenWrapper(variableToken, line, startPos, endPos, value);
    Assert.assertEquals(variableToken, t.getToken());
    Assert.assertEquals(variableToken.getName(), t.getName());
    Assert.assertEquals(variableToken.toString(), t.toString());
    Assert.assertEquals(variableToken.getRegex(), t.getRegex());
    Assert.assertEquals(line, t.getLine());
    Assert.assertEquals(startPos, t.getStartPos());
    Assert.assertEquals(endPos, t.getEndPos());
    Assert.assertEquals(value, t.getValue());
  }
  
  @Test
  public void test006_WhenThePatternMatchesTokenWrapperVerifyShouldReturnTrue() {
    final Token t1 = Token.NUMBER_LITERAL_TOKEN;
    final Token t2 = Token.SEMICOLON_TOKEN;
    final Token t3 = Token.LET_TOKEN;
    final TokenWrapper tw1 = new TokenWrapper(t1, 0, 0, 0, "");
    final TokenWrapper tw2 = new TokenWrapper(t2, 0, 0, 0, "");
    final TokenWrapper tw3 = new TokenWrapper(t3, 0, 0, 0, "");
    final String s1 = "123.123";
    final String s2 = ";";
    final String s3 = "let";
    
    Assert.assertTrue(tw1.verify(s1));
    Assert.assertTrue(tw2.verify(s2));
    Assert.assertTrue(tw3.verify(s3));
  }
  
  @Test
  public void test007_WhenThePatternDoesNotMatchTokenWrapperVerifyShouldReturnFalse() {
    final Token t1 = Token.STRING_TYPE_TOKEN;
    final Token t2 = Token.LET_TOKEN;
    final Token t3 = Token.DIV_OPERATION_TOKEN;
    final TokenWrapper tw1 = new TokenWrapper(t1, 0, 0, 0, "");
    final TokenWrapper tw2 = new TokenWrapper(t1, 0, 0, 0, "");
    final TokenWrapper tw3 = new TokenWrapper(t1, 0, 0, 0, "");
    final String s1 = "/";
    final String s2 = ";";
    final String s3 = "let";
    
    Assert.assertFalse(tw1.verify(s1));
    Assert.assertFalse(tw2.verify(s2));
    Assert.assertFalse(tw3.verify(s3));
  }
  
  @Test
  public void test008_WhenGetTokenOnTupleShouldReturnIt() {
    final Tuple tuple = new Tuple(Token.LET_TOKEN, "string");
    Assert.assertEquals(Token.LET_TOKEN, tuple.getToken());
  }
  
  @Test
  public void test009_WhenGetStringOnTupleShouldReturnItWithoutQuotes() {
    final Tuple tuple = new Tuple(Token.LET_TOKEN, "'string'");
    Assert.assertEquals("string", tuple.getString());
  }
}
