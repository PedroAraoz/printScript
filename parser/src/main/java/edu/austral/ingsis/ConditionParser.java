package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConditionParser {

  final private ASTFactory astFactory;
  final private TokenToASTConverter tokenToASTConverter = new TokenToASTConverter();

  public ConditionParser(ASTFactory astFactory) {
    this.astFactory = astFactory;
  }

  public AbstractSyntaxTree analyseSintactically(List<Token> tokenList) throws CompilationTimeException {
    for (Token token : tokenList) {
      if (token.getTokenIdentifier().equals(TokenIdentifier.ELSE_TOKEN)) {
        List<Token> ifList = tokenList.subList(0, tokenList.indexOf(token));
        List<Token> elseList = tokenList.subList(tokenList.indexOf(token)+1, tokenList.size());
        IfOperationSyntaxBranch ifAST = (IfOperationSyntaxBranch) parseIf(ifList);
        List<AbstractSyntaxTree> elseASTs = parseElse(elseList);
        ifAST.addElseStatements(elseASTs);
        return ifAST;
      }
    }
    return parseIf(tokenList);
  }

  private List<AbstractSyntaxTree> parseElse(List<Token> elseList) throws CompilationTimeException {
    elseList.remove(elseList.get(0));
    List<List<Token>> sentences = getSentences(elseList);
    return getAbstractSyntaxTrees(sentences);
  }

  private AbstractSyntaxTree parseIf(List<Token> tokenList) throws CompilationTimeException {
    Token _if = tokenList.get(0);
    Token conditionToken = tokenList.get(2);
    List<Token> header = new ArrayList<>();
    List<Token> body = new ArrayList<>();
    Iterator<Token> iterator = tokenList.iterator();
    destructureAfter(header, iterator, TokenIdentifier.LEFT_BRACKET_TOKEN);
    destructureBefore(body, iterator, TokenIdentifier.RIGHT_BRACKET_TOKEN);

    List<List<Token>> sentences = getSentences(body);

    IfOperationSyntaxBranch ifTree = (IfOperationSyntaxBranch) tokenToASTConverter.convert(_if);
    VariableSyntaxLeaf condition = (VariableSyntaxLeaf) tokenToASTConverter.convert(conditionToken);
    ifTree.setCondition(condition);

    List<AbstractSyntaxTree> ifTrees = getAbstractSyntaxTrees(sentences);

    ifTree.addIfTrees(ifTrees);
    return ifTree;
  }

  private List<AbstractSyntaxTree> getAbstractSyntaxTrees(List<List<Token>> sentences) throws CompilationTimeException {
    List<AbstractSyntaxTree> ifTrees = new ArrayList<>();
    if (!sentences.isEmpty()) {
      for (List<Token> sentence : sentences) {
        ifTrees.add(astFactory.build(sentence));
      }
    }
    return ifTrees;
  }

  private List<List<Token>> getSentences(List<Token> body) {
    List<List<Token>> sentences = new ArrayList<>();
    Iterator<Token> iterator = body.iterator();
    while (iterator.hasNext()) {
      List<Token> sentence = new ArrayList<>();
      destructureUnless(sentence, iterator, TokenIdentifier.SEMICOLON_TOKEN, TokenIdentifier.RIGHT_BRACKET_TOKEN);
      if (!sentence.isEmpty()) sentences.add(sentence);
    }
    return sentences;
  }

  private void destructureBefore(List<Token> accumulator, Iterator<Token> iterator, TokenIdentifier tokenIdentifier) {
    while (iterator.hasNext()) {
      Token token = iterator.next();
      accumulator.add(token);
      if (token.getTokenIdentifier().equals(tokenIdentifier)) {
        break;
      }
    }
  }

  private void destructureAfter(List<Token> accumulator, Iterator<Token> iterator, TokenIdentifier tokenIdentifier) {
    while (iterator.hasNext()) {
      Token token = iterator.next();
      if (token.getTokenIdentifier().equals(tokenIdentifier)) {
        break;
      }
      accumulator.add(token);
    }
  }

  private void destructureUnless(List<Token> accumulator, Iterator<Token> iterator, TokenIdentifier tokenIdentifier, TokenIdentifier unless) {
    while (iterator.hasNext()) {
      Token token = iterator.next();
      if (token.getTokenIdentifier().equals(unless)) {
        break;
      }
      accumulator.add(token);
      if (token.getTokenIdentifier().equals(tokenIdentifier)) {
        break;
      }
    }
  }
}
