package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
//    CLI cli = new CLI(new CLIPrinter());
//    try {
//      cli.run();
//    } catch (FileNotFoundException | CompilationTimeException e) {
//      e.printStackTrace();
//    }
    
    final Pattern p = Pattern.compile("([0-9]+.[0-9]+)|[0-9]+");
    String string = "12345Nolopuedocreer2.2hola";
    final Matcher matcher = p.matcher(string);
    List<String> all = new ArrayList<>();
    all = matcher.results().map(MatchResult::group).collect(Collectors.toList());
    for (String s : all) {
      final List<String> strings = Arrays.asList(string.split(s));
    }
    
  }
}
// todo tenemos el bug que se come los espacios adentro de los string literals
