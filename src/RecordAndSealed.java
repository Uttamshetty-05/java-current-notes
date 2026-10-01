/**
 * Records are immutable data carriers. Sealed types let you model a closed
 * set of results without a huge class hierarchy.
 */
public class RecordAndSealed {
    public sealed interface Result permits Ok, Err {
    }

    public record Ok(String value) implements Result {
    }

    public record Err(String message) implements Result {
    }

    public static String describe(Result result) {
        return switch (result) {
            case Ok(String value) -> "ok: " + value;
            case Err(String message) -> "error: " + message;
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(new Ok("compiled")));
        System.out.println(describe(new Err("missing JDK 21+")));
    }
}
