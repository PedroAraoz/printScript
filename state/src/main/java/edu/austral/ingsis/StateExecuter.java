package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.io.FileNotFoundException;

public class StateExecuter implements State {

    private CLI cli;
    private final Lexer lexer;
    private final Parser parser;
    private final InterpreterVisitor interpreter;
    private final FileGenerator fileGenerator;
    private final StateFactory stateFactory;
    private final Printer printer;
    public StateExecuter(Lexer lexer, Parser parser, InterpreterVisitor interpreter, FileGenerator fileGenerator, StateFactory stateFactory, Printer printer) {
        this.lexer = lexer;
        this.parser = parser;
        this.interpreter = interpreter;
        this.fileGenerator = fileGenerator;
        this.stateFactory = stateFactory;
        this.printer = printer;
    }

    @Override
    public void setContext(CLI cli) {
        this.cli = cli;
    }

    @Override
    public void run(String[] args) throws FileNotFoundException, CompilationTimeException {
        execute(args);
    }

    private void execute(String[] args) throws FileNotFoundException, CompilationTimeException {
        // todo capaz a este nivel conviene tener un error handler o algo. tipo
        // que le pasas los errores y ese se comunica con el cli/print y los escupe
        // en vez de tener ese throws Error feo
        if (!checkMode(args[0])) return;
        final File file = fileGenerator.open(args[1]);
        printer.print("Starting...");
//        final int totalLines = file.getLines();
//        int currentLine = 0;
//        lexer.setVersion(args[2]);
//        while (file.hasNext()) {
//            printer.print(currentLine + "/" + totalLines);
//            final List<Token> tokens = lexer.analyseLexically(file.next().get());
//            final AbstractSyntaxTree ast = parser.analyseSintactically(tokens);
//            interpreter.visit(ast);
//            currentLine++;
//            ((InterpreterVisitorImpl) interpreter).debug();
//        }
    }

    private boolean checkMode(String mode) {
        if (mode.equals("execute")) return true;
        cli.changeState(stateFactory.get(mode));
        return false;
    }
}
//todo checkear que la var existe cuando haces el interpreter
