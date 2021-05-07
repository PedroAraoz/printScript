package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConditionParser {

  private final ASTFactory astFactory;
  private final TokenToASTConverter tokenToASTConverter = new TokenToASTConverter();

  public ConditionParser(ASTFactory astFactory) {
    this.astFactory = astFactory;
  }

  public AbstractSyntaxTree analyseSintactically(List<OurToken> tokenList)
      throws CompilationTimeException {
    for (OurToken token : tokenList) {
      if (token.getTokenIdentifier().equals(TokenIdentifier.ELSE_TOKEN)) {
        List<OurToken> ifList = tokenList.subList(0, tokenList.indexOf(token));
        List<OurToken> elseList = tokenList.subList(tokenList.indexOf(token) + 1, tokenList.size());
        IfOperationSyntaxBranch ifAST = (IfOperationSyntaxBranch) parseIf(ifList);
        List<AbstractSyntaxTree> elseASTs = parseElse(elseList);
        ifAST.addElseStatements(elseASTs);
        return ifAST;
      }
    }
    return parseIf(tokenList);
  }

  private List<AbstractSyntaxTree> parseElse(List<OurToken> elseList)
      throws CompilationTimeException {
    elseList.remove(elseList.get(0));
    List<List<OurToken>> sentences = getSentences(elseList);
    return getAbstractSyntaxTrees(sentences);
  }

  private AbstractSyntaxTree parseIf(List<OurToken> tokenList) throws CompilationTimeException {
    OurToken _if = tokenList.get(0);
    OurToken conditionToken = tokenList.get(2);
    List<OurToken> header = new ArrayList<>();
    List<OurToken> body = new ArrayList<>();
    Iterator<OurToken> iterator = tokenList.iterator();
    destructureAfter(header, iterator, TokenIdentifier.LEFT_BRACKET_TOKEN);
    destructureBefore(body, iterator, TokenIdentifier.RIGHT_BRACKET_TOKEN);

    List<List<OurToken>> sentences = getSentences(body);

    IfOperationSyntaxBranch ifTree = (IfOperationSyntaxBranch) tokenToASTConverter.convert(_if);
    VariableSyntaxLeaf condition = (VariableSyntaxLeaf) tokenToASTConverter.convert(conditionToken);
    ifTree.setCondition(condition);

    List<AbstractSyntaxTree> ifTrees = getAbstractSyntaxTrees(sentences);

    ifTree.addIfTrees(ifTrees);
    return ifTree;
  }

  private List<AbstractSyntaxTree> getAbstractSyntaxTrees(List<List<OurToken>> sentences)
      throws CompilationTimeException {
    List<AbstractSyntaxTree> ifTrees = new ArrayList<>();
    if (!sentences.isEmpty()) {
      for (List<OurToken> sentence : sentences) {
        ifTrees.add(astFactory.build(sentence));
      }
    }
    return ifTrees;
  }

  private List<List<OurToken>> getSentences(List<OurToken> body) {
    List<List<OurToken>> sentences = new ArrayList<>();
    Iterator<OurToken> iterator = body.iterator();
    while (iterator.hasNext()) {
      List<OurToken> sentence = new ArrayList<>();
      destructureUnless(
          sentence, iterator, TokenIdentifier.SEMICOLON_TOKEN, TokenIdentifier.RIGHT_BRACKET_TOKEN);
      if (!sentence.isEmpty()) sentences.add(sentence);
    }
    return sentences;
  }

  private void destructureBefore(
      List<OurToken> accumulator, Iterator<OurToken> iterator, TokenIdentifier tokenIdentifier) {
    while (iterator.hasNext()) {
      OurToken token = iterator.next();
      accumulator.add(token);
      if (token.getTokenIdentifier().equals(tokenIdentifier)) {
        break;
      }
    }
  }

  private void destructureAfter(
      List<OurToken> accumulator, Iterator<OurToken> iterator, TokenIdentifier tokenIdentifier) {
    while (iterator.hasNext()) {
      OurToken token = iterator.next();
      if (token.getTokenIdentifier().equals(tokenIdentifier)) {
        break;
      }
      accumulator.add(token);
    }
  }

  private void destructureUnless(
      List<OurToken> accumulator,
      Iterator<OurToken> iterator,
      TokenIdentifier tokenIdentifier,
      TokenIdentifier unless) {
    while (iterator.hasNext()) {
      OurToken token = iterator.next();
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
