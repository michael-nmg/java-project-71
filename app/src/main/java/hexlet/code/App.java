package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "Generate differences, version 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"},
            paramLabel = "format",
            defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    @Parameters(index = "0",
            paramLabel = "filepath1",
            description = "path to first file")
    private String filePath1;

    @Parameters(index = "1",
            paramLabel = "filepath2",
            description = "path to second file")
    private String filePath2;

    @Override
    public Integer call() throws Exception {
        Path first = Paths.get(filePath1);
        Path second = Paths.get(filePath2);

        String check = FileChecker.isAvailable(first, second);

        if (check.isEmpty()) {
            var firstMap = ParseFile.parse(first);
            var secondMap = ParseFile.parse(second);
            var calcDiff = FindingDifferences.search(firstMap, secondMap);
            System.out.println(Presentation.plainTextPresentation(calcDiff));
        } else {
            System.err.println(check);
        }

        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
