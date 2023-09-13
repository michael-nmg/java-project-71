package hexlet.code.presentation;

public class PresentationFactory {

    public static Presentation select(String format) throws RuntimeException {
        return switch (format) {
            case "plain" -> new PresentationPlain();
            case "json" -> new PresentationStylish();
            case "stylish" -> new PresentationStylish();
            default -> throw new RuntimeException("Unused format.");
        };
    }
}
