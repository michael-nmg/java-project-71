package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "Generate differences, version 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    private static final int SUCCES_CODE = 0;
    private static final int ERROR_CODE = 1;

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
    public Integer call() {
        try {
            String check = FileUtils.available(filePath1, filePath2);
            if (check.isEmpty()) {
                var result = GenerateDifferences.generate(format, filePath1, filePath2);
                System.out.println(result);
                return SUCCES_CODE;
            } else {
                System.out.println(check);
                return ERROR_CODE;
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return ERROR_CODE;
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
