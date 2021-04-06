package edu.austral.ingsis;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CLI {
  private State state;
  private Printer printer;
  
  
  public void changeState(State state) {
    this.state = state;
    state.setContext(this);
  }
  
  public void run() throws FileNotFoundException {
    final Scanner scanner = new Scanner(System.in);
    String message = "";
    String welcomeMessage = "please type\n" +
            "<mode> <filePath>";
    print(welcomeMessage);
    while (!message.equals("exit")) {
      message = scanner.nextLine().trim().toLowerCase();
      final String[] args = message.split(" ");
      if (args.length != 2) throw new RuntimeException("AAAAA"); //todo implement mejor
      //todo por algun lugar mirar que este bien armando con mode filepath
      state.run(args);
    }
  }
  
  public void print(String s) {
    //todo implement
    System.out.println(s);
  }
}
