import java.util.List;

public class ListContains {
    public static boolean containsValue(List<Integer> list, Integer value) {
         return list.contains(value);
        // your code here
    }
     public static void main(String[] args) {
        System.out.println(ListContains.containsValue(List.of(9, 13, 8, 23, 1, 0, 89), 8));
        System.out.println(ListContains.containsValue(List.of(9, 13, 8, 23, 1, 0, 89), 10));
    }
    }
