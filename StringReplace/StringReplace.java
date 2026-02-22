
public class StringReplace {
    public static <T> String replace(String s, T target, T replacement) {
if (s == null) {
    return "";
}
        return s.replace(target.toString(), replacement.toString() );
        // your code here
    }
}