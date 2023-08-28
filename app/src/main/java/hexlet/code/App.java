package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "Generate differences, version 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("Hello World!");
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
