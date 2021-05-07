public class IntegrationTests {

  //    @Test
  //    public void integrationTest1() throws CompilationTimeException {
  //        String a = "let x: number = 1";
  //
  //        List<TokenWrapper> lexerResult = new LexerImpl().analyseLexically(new CodeLine(a, 0));
  //
  //        VariableRegister variableRegister = new VariableRegister();
  //
  //        Parser parser = new ParserImpl(variableRegister);
  //
  //        AbstractSyntaxTree ast = parser.analyseSintactically(lexerResult);
  //
  //        parser.analyseSemantically(ast);
  //
  //        Interpreter interpreter = new InterpreterImpl(variableRegister);
  //
  //        List<String> logs = interpreter.interpret(ast);
  //
  //        for (String log : logs) {
  //            System.out.println(log);
  //        }
  //
  //        assert variableRegister.contains("x");
  //        assert variableRegister.get("x").get().getValue().equals("1.0");
  //    }
}
