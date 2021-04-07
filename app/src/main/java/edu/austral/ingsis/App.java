package edu.austral.ingsis;

import java.io.FileNotFoundException;

public class App {
  //  public static void main(String[] args) throws FileNotFoundException {
  //
  //    final String path = "app/src/test/resources/myCode.txt";
  //    final FileGenerator fileGenerator = new NormalFileGenerator();
  //    final File file = fileGenerator.open(path);
  //
  //    final Lexer lexer = new LexerImpl();
  //
  //    final List<List<TokenWrapper>> lists = new ArrayList<>();
  //
  //    while (file.hasNext()) {
  //      lists.add(lexer.analyseLexically(file.next()));
  //    }
  //
  //    final Parser parser = new ParserImpl();
  //
  //    final List<AbstractSyntaxTree> abstractSyntaxTreeList = new ArrayList<>();
  //
  //    for (List<TokenWrapper> tokenWrapperList : lists) {
  //      abstractSyntaxTreeList.add(parser.analyseSintactically(tokenWrapperList));
  //    }
  //
  //    System.out.println("The compilation ended succesfully");
  //  }
  // execute state/src/main/resources/test.txt
  public static void main(String[] args) {
    CLI cli = new CLI();
    try {
      cli.run();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
