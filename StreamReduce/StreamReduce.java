import java.io.IOException;
import java.util.stream.Stream;

public class StreamReduce {
    public static Integer sumAll(Stream<Integer> s) {
        // your code here
        return s.reduce((a, b) -> a + b).orElse(0);
    }

    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        // your code here
        return s.map(e -> e / divider).reduce((a, b) -> a + b).orElse(0);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(StreamReduce.sumAll(Stream.of(3, 5, 7, 10)));
        System.out.println(StreamReduce.sumAll(Stream.of()));
        System.out.println(StreamReduce.divideAndAddElements(Stream.of(3, 5, 7, 10), 2));
        System.out.println(StreamReduce.divideAndAddElements(Stream.of(), 2));
    }
}
