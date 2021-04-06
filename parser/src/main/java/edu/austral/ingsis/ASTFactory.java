package edu.austral.ingsis;

import edu.austral.ingsis.visitor.EmptyValidatorVisitor;

import java.util.List;
import java.util.Stack;

public class ASTFactory {

  public AbstractSyntaxTree build(List<TokenWrapper> tokenWrapperList) {

    final Stack<AbstractSyntaxTree> abstractSyntaxTreeStack = new Stack<>();
    final TokenToASTConverter tokenToASTConverter = new TokenToASTConverter();

    for (TokenWrapper t : tokenWrapperList) {
      abstractSyntaxTreeStack.add(tokenToASTConverter.convert(t));
    }

    while (abstractSyntaxTreeStack.size() > 1) {
      AbstractSyntaxTree one = abstractSyntaxTreeStack.pop();
      AbstractSyntaxTree combined = abstractSyntaxTreeStack.pop().add(one);
      abstractSyntaxTreeStack.push(combined);
    }

    final EmptyValidatorVisitor visitor = new EmptyValidatorVisitor();

    abstractSyntaxTreeStack.peek().accept(visitor);

    if (visitor.foundEmpty()) {

      // Aca hay que poner un error
      System.out.println("Empty found");
      return null;
    }

    return abstractSyntaxTreeStack.pop();
  }
}
