import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class KeepTheChange {
  public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> list = coins.stream().collect(Collectors.toList());
        Collections.sort(list);
        Collections.reverse(list);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            while (amount - list.get(i) >= 0) {
                res.add(list.get(i));
                amount -= list.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(KeepTheChange.computeChange(18, Set.of(1, 3, 7)));
    }
}