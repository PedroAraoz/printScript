package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {

  private final ASTFactory astFactory;
  private ParserSegmenter parserSegmenter;

  public ParserImpl() {
    this.astFactory = new ASTFactory();
  }

  @Override
  public AbstractSyntaxTree analyseSintactically(List<OurToken> tokenList)
      throws CompilationTimeException {
    if (tokenList.get(0).getTokenIdentifier().equals(TokenIdentifier.IF_TOKEN)) {
      ConditionParser conditionParser = new ConditionParser(astFactory);
      return conditionParser.analyseSintactically(tokenList);
    } else {
      return astFactory.build(tokenList);
    }
  }

  @Override
  public List<AbstractSyntaxTree> analyseSintactically(OurLexer lexer)
      throws CompilationTimeException {
    this.parserSegmenter = new ParserSegmenter(lexer);
    final List<AbstractSyntaxTree> abstractSyntaxTrees = new ArrayList<>();
    while (this.parserSegmenter.hasNext()) {
      abstractSyntaxTrees.add(analyseSintactically(parserSegmenter.getNext()));
    }
    return abstractSyntaxTrees;
  }
}
