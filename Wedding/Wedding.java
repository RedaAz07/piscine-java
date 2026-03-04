import java.util.*;

public class Wedding {

    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {

        List<String> flist = new ArrayList<>(first);
        List<String> slist = new ArrayList<>(second);

        Collections.shuffle(flist);
        Collections.shuffle(slist);

        int length = Math.min(flist.size(), slist.size());

        Map<String, String> couples = new HashMap<>();

        for (int i = 0; i < length; i++) {
            couples.put(flist.get(i), slist.get(i));
        }

        return couples;
    }
}