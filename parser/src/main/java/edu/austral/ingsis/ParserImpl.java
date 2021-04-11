package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.util.List;

public class ParserImpl implements Parser {

  public ParserImpl() {
    this.astFactory = new ASTFactory();
//    this.astVerifier = new ASTVerifier(variableRegister);
  }

  private final ASTFactory astFactory;
//  private final ASTVerifier astVerifier;

  @Override
  public AbstractSyntaxTree analyseSintactically(List<TokenWrapper> tokenWrapperList) throws CompilationTimeException {
    return astFactory.build(tokenWrapperList);
  }

//  @Override
//  public void analyseSemantically(AbstractSyntaxTree ast) throws CompilationTimeException {
//    astVerifier.verify(ast);
//  }
}
