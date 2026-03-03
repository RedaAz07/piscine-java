import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        // your code here
        return (int) s.mapToInt(k -> k.length()).sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        // your code here
        return s.filter(str -> str != null && !str.isEmpty()).map(k -> k.toUpperCase()).collect(Collectors.toList());
    }

    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        // your code here
       return  s.filter(k->k>42.0).map(k ->k.intValue()).collect(Collectors.toSet());

    }

    public static void main(String[] args) throws IOException {
        System.out.println(StreamMap.sumOfStringLength(Stream.of("Bonjour", "le", "monde !")));
        System.out.println(StreamMap.upperCaseAllString(Stream.of("IL", "Fait", "beaU !!")));
        System.out.println(StreamMap.uniqIntValuesGreaterThan42(Stream.of(23.439, 42.34, 39194.4)));
    }

}
