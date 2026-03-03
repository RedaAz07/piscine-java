import java.util.List;

public class ListEquals {
    public static boolean areListsEqual(List<String> list1, List<String> list2) {

        return !list2.isEmpty() && !list1.isEmpty() && list1 != null && list2 != null && list1.equals(list2);
        // your code here
    }

    public static void main(String[] args) {
        System.out.println(ListEquals.areListsEqual(null,
                List.of("Alice", "Bob", "Charly", "Emily")));
        System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"),
                List.of("Alice", "Bob", "Emily", "Charly")));
    }
}