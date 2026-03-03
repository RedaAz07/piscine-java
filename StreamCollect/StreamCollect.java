import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {

        return s.filter(word -> word != null && !word.isEmpty())
                .collect(Collectors.groupingBy(k -> Character.toUpperCase(k.charAt(0))));
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        // your code here
        return s.filter(k -> k != null).collect(Collectors.groupingBy(k -> k % 4, Collectors.maxBy(Integer::compare)));
    }

    public static String orderAndConcatWithSharp(Stream<String> s) {
        // your code here
        String k = s.filter(word -> word != null && !word.isEmpty()).sorted().collect(Collectors.joining(" # "));
        StringBuilder res  =  new StringBuilder();
        res.append("{");
        res.append(k);
        res.append("}");
        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(StreamCollect.mapByFirstLetter(Stream.of("Bonjour", "le", "monde !", "bonsoir")));

        System.out.println(StreamCollect.getMaxByModulo4(Stream.of(5, 12, 32, 4, 9,
                17, 98, 424, 97, 5843, 48354)));
        System.out.println(StreamCollect
                .orderAndConcatWithSharp(Stream.of("Hello", "how are you ?",
                        "where do you live ?", "Bordeaux")));

    }
}
