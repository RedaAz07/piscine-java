import java.util.Objects;
public class StringConcat {
    public static String concat(String s1, String s2) {
        return Objects.toString(s1,"") + Objects.toString(s2,"");
    }
}