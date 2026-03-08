
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {
    public static String removeUnits(String s) {
        // your code here
        boolean k = s.matches("[0-9]+(cm|€)(\\s+|$).*");
        if (k) {
            return s.replace("cm", "");
        }
        return s;
    }

     public static String obfuscateEmail(String email) {

        String usernamePattern = "^(.*?)([-._])(.*)$";
        Matcher m = Pattern.compile(usernamePattern).matcher(email);
        if (m.find()) {
            String before = m.group(1);
            String sep = m.group(2);
            String after = m.group(3);

            if (!before.isEmpty()) {
                before = before.substring(0, before.length() - 1) + "*";
            }
            if (!after.isEmpty()) {
                after = "*" + after.substring(1);
            }

            email = before + sep + after;
        } else {
            email = email.replaceFirst("^(.{3})", "***");
        }

        String domainPattern = "@([^.]+)(?:\\.([^.]+))?(?:\\.([^.]+))?$";
        m = Pattern.compile(domainPattern).matcher(email);

        if (m.find()) {
            String third = m.group(1);
            String second = m.group(2);
            String top = m.group(3);

            String newDomain = "";

            if (top != null && second != null) {
                newDomain = "@***." + second + ".***";
            } else if (second != null) {
                if (!top.equals("com") && !top.equals("org") && !top.equals("net")) {
                    newDomain = "@***.***";
                } else {
                    newDomain = "@" + third + "." + top;
                }
            }

            email = email.replaceAll(domainPattern, newDomain);
        }

        return email;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(RegexReplace.removeUnits("32cm rg reg re g"));
        System.out.println(RegexReplace.removeUnits("32 cm et 50 €"));
        System.out.println(RegexReplace.removeUnits("32cms et 50€!"));

        System.out.println(RegexReplace.obfuscateEmail("john.doe@example.com"));
        System.out.println(RegexReplace.obfuscateEmail("jann@example.co.org"));
        System.out.println(RegexReplace.obfuscateEmail("jackob@example.fr"));
    }
}