package edu.austral.ingsis;

import edu.austral.ingsis.exception.CompilationTimeException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StateExecuter implements State {

    private CLI cli;
    private final Lexer lexer;
    private final Parser parser;
    private final Interpreter interpreter;
    private final FileGenerator fileGenerator;
    private final StateFactory stateFactory;

    public StateExecuter(Lexer lexer, Parser parser, Interpreter interpreter, FileGenerator fileGenerator, StateFactory stateFactory) {
        this.lexer = lexer;
        this.parser = parser;
        this.interpreter = interpreter;
        this.fileGenerator = fileGenerator;
        this.stateFactory = stateFactory;
    }

    @Override
    public void setContext(CLI cli) {
        this.cli = cli;
    }

    @Override
    public List<String> run(String[] args) throws FileNotFoundException, CompilationTimeException {
        return execute(args);
    }

    private List<String> execute(String[] args) throws FileNotFoundException, CompilationTimeException {
        // todo capaz a este nivel conviene tener un error handler o algo. tipo
        // que le pasas los errores y ese se comunica con el cli/print y los escupe
        // en vez de tener ese throws Error feo
        if (!checkMode(args[0])) return Collections.emptyList();
        final File file = fileGenerator.open(args[1]);
        List<String> all = new ArrayList<>();
        while (file.hasNext()) {
            final List<TokenWrapper> tokenWrappers = lexer.analyseLexically(file.next().get());
            final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(tokenWrappers);
//            final List<String> logs = interpreter.interpret(abstractSyntaxTree);
//            all.addAll(logs);
        }
//        final List<List<TokenWrapper>> tokenWrappers = new ArrayList<>();
//        while (file.hasNext()) {
//            tokenWrappers.add(lexer.analyseLexically(file.next().get()));
//        }
//        List<AbstractSyntaxTree> abstractSyntaxTreeList = new ArrayList<>();
//        for (List<TokenWrapper> t : tokenWrappers) {
//            final AbstractSyntaxTree abstractSyntaxTree = parser.analyseSintactically(t);
//            abstractSyntaxTreeList.add(abstractSyntaxTree);
//        }
//        for (AbstractSyntaxTree ast : abstractSyntaxTreeList) {
//            parser.analyseSemantically(ast);
//        }
//        for (AbstractSyntaxTree ast : abstractSyntaxTreeList) {
//            final List<String> interpret = interpreter.interpret(ast);
//            all.addAll(interpret);
//        }
        return all;
    }

    private boolean checkMode(String mode) {
        if (mode.equals("execute")) return true;
        cli.changeState(stateFactory.get(mode));
        return false;
    }
}
