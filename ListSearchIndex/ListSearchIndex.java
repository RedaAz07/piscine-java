import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        // your code here
        if (list.isEmpty() ) {
            return null;
        }
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).equals(value)) {
                return i;
            }

        }
        return null;
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        // your code here
        if (list.isEmpty() ) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                return i;
            }

        }
        return null;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> res = new ArrayList<>();
        if (list.isEmpty() ) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                res.add(i);
            }

        }
        return res;
        // your code here
    }

    public static void main(String[] args) {
        System.out.println(ListSearchIndex.findLastIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
        System.out.println(ListSearchIndex.findFirstIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
        System.out.println(ListSearchIndex.findAllIndexes(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89).toString());
    }
}