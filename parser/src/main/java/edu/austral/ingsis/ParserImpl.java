package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.List;

public class ParserImpl implements Parser {

  private final ASTFactory astFactory = new ASTFactory();
  private final ASTVerifier astVerifier = new ASTVerifier(new VariableRegister());

  @Override
  public AbstractSyntaxTree analyseSintactically(List<TokenWrapper> tokenWrapperList) throws CompilationTimeException {
    AbstractSyntaxTree ast = astFactory.build(tokenWrapperList);
    astVerifier.verify(ast);
    return ast;
  }

  @Override
  public void analyseSemantically(AbstractSyntaxTree ast) throws CompilationTimeException {
    astVerifier.verify(ast);
  }
}
