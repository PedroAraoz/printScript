package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) throws FileNotFoundException {

    final String path = "src/test/resources/myCode.txt";
    final FileGenerator fileGenerator = new NormalFileGenerator();
    final File file = fileGenerator.open(path);

    final Lexer lexer = new LexerImpl();

    final List<List<TokenWrapper>> lists = new ArrayList<>();

    while (file.hasNext()) {
      lists.add(lexer.analyseLexically(file.next()));
    }

    final Parser parser = new ParserImpl();

    final List<AbstractSyntaxTree> abstractSyntaxTreeList = new ArrayList<>();

    for (List<TokenWrapper> tokenWrapperList : lists){
      abstractSyntaxTreeList.add(parser.analyseSintactically(tokenWrapperList));
    }

    System.out.println("The compilation ended succesfully");
  }
}
