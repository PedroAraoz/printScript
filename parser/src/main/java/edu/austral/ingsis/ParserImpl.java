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
  public AbstractSyntaxTree analyseSintactically(List<Token> tokenList)
      throws CompilationTimeException {
    return astFactory.build(tokenList);
  }

  @Override
  public List<AbstractSyntaxTree> analyseSintactically(Lexer lexer)
      throws CompilationTimeException {
    parserSegmenter = new ParserSegmenter(lexer);
    final List<AbstractSyntaxTree> abstractSyntaxTrees = new ArrayList<>();
    while (parserSegmenter.hasNext())
      abstractSyntaxTrees.add(analyseSintactically(parserSegmenter.getNext()));
    return abstractSyntaxTrees;
  }
}
