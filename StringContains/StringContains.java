public class StringContains {
    public static boolean isStringContainedIn(String subString, String s) {
        // your code here
        return subString != null && s != null && s.contains(subString);
    }
}