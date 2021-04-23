package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;
import java.io.FileNotFoundException;

public class App {
  public static void main(String[] args) throws CompilationTimeException {
    CLI cli = new CLI(new CLIPrinter());
    try {
      cli.run();
    } catch (FileNotFoundException | CompilationTimeException e) {
      e.printStackTrace();
    }

    //    final Pattern p = Pattern.compile("([0-9]+.[0-9]+)|[0-9]+");
    //    String string = "12345Nolopuedocreer2.2hola";
    //    final Matcher matcher = p.matcher(string);
    //    List<String> all = new ArrayList<>();
    //    all = matcher.results().map(MatchResult::group).collect(Collectors.toList());
    //    for (String s : all) {
    //      final List<String> strings = Arrays.asList(string.split(s));
    //    }

  }
}
