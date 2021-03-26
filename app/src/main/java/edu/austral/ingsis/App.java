package edu.austral.ingsis;

import java.util.regex.Pattern;

public class App {
  public static void main(String[] args) {
    // Ejemplo de como funciona el java pattern para expresiones regulares.
    Pattern p = Pattern.compile("=");
    System.out.println(p.matcher("as").matches());
    System.out.println(p.matcher("2").matches());
    System.out.println(p.matcher("=").matches());
  }
}
