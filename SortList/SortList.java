import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null)
            return null;
        List<Integer> result = new ArrayList<>(list);
        Collections.sort(result);
        return result;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null)
            return null;
        List<Integer> result = new ArrayList<>(list);
        Collections.sort(result);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SortList.sort(List.of(15, 1, 14, 18, 14, 98, 54, -1, 12)).toString());

        System.out.println(SortList.sortReverse(List.of(15, 1, 14, 18, 14, 98, 54, -1, 12)).toString());
    }
}
