package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.util.List;
import java.util.Stack;

public class ASTFactory {

  public AbstractSyntaxTree build(List<Token> tokenList) throws CompilationTimeException {

    final Stack<AbstractSyntaxTree> abstractSyntaxTreeStack = new Stack<>();
    final TokenToASTConverter tokenToASTConverter = new TokenToASTConverter();

    // First we convert all of the tokenIdentifiers insto AST nodes

    for (Token t : tokenList) {
      abstractSyntaxTreeStack.add(tokenToASTConverter.convert(t));
    }

    // Then we fold the node list unto itself to validate the structure (order of the
    // tokenIdentifiers)

    while (abstractSyntaxTreeStack.size() > 1) {
      AbstractSyntaxTree one = abstractSyntaxTreeStack.pop();
      AbstractSyntaxTree combined = abstractSyntaxTreeStack.pop().add(one);
      abstractSyntaxTreeStack.push(combined);
    }

    // Next we need to validate that the tree has no empty spaces. We do this though a visitor

    final EmptyValidatorVisitor visitor = new EmptyValidatorVisitor();
    abstractSyntaxTreeStack.peek().accept(visitor);
    if (visitor.foundEmpty()) {
      throw new CompilationTimeException("Syntax Error in line " + tokenList.get(0).getLine());
    }

    return abstractSyntaxTreeStack.pop();
  }
}
