import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPipeline {
    public record Topic(String name, String area, int difficulty) {
    }

    public static void main(String[] args) {
        List<Topic> topics = List.of(
                new Topic("virtual threads", "concurrency", 3),
                new Topic("records", "language", 1),
                new Topic("Spring AI", "ai", 4),
                new Topic("G1 GC", "jvm", 3),
                new Topic("LangChain4j", "ai", 4)
        );

        Map<String, Long> byArea = topics.stream()
                .collect(Collectors.groupingBy(Topic::area, Collectors.counting()));

        List<String> hardAi = topics.stream()
                .filter(t -> t.difficulty() >= 4)
                .map(Topic::name)
                .sorted()
                .toList();

        System.out.println("counts: " + byArea);
        System.out.println("hard AI topics: " + hardAi);
    }
}
