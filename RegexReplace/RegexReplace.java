
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {
    public static String removeUnits(String s) {
        // your code here
        boolean k = s.matches("[0-9]+(cm|€)(\\s+|$).*");
        if (k) {
            return s.replace("cm", "").replaceAll("€", "");
        }
        return s;
    }

    public static String obfuscateEmail(String email) {
        String sub = "";
        String secSub = "";
        if (email.contains("@")) {
            sub = email.substring(0, email.indexOf("@"));
            secSub = email.substring(email.indexOf("@"), email.length());

        } else {
            return null;
        }
        Pattern p = Pattern.compile("(\\.|-|_)");
        Matcher matcher = p.matcher(sub);
        if (sub.contains(".") || sub.contains("-") || sub.contains("_")) {
            while (matcher.find()) {
                sub = sub.substring(0, matcher.start()) + matcher.group() + "*".repeat(sub.length() - matcher.end());
            }
        } else {
            sub = sub.substring(0, 3) + "*".repeat(sub.length() - 3);
        }

        long count = secSub.chars().filter(ch -> ch == '.').count();
        List<Integer> matchIndexes = new ArrayList<>();

        if (count == 2) {
            Pattern pa = Pattern.compile("(\\.)");
            Matcher matcherr = pa.matcher(secSub);
            while (matcherr.find()) {
                int startIndex = matcherr.start();
                matchIndexes.add(startIndex);
            }
            secSub = "@" + "*".repeat(matchIndexes.get(0) - 1)
                    + secSub.substring(matchIndexes.get(0), matchIndexes.get(1))
                    + "." + "*".repeat((secSub.length() - matchIndexes.get(1)) - 1);
            return sub + secSub;
        } else {
            if (secSub.contains(".com") || secSub.contains(".org") || secSub.contains(".net")) {
                secSub = "@" + "*".repeat(secSub.indexOf(".")-1) +  secSub.substring(secSub.indexOf("."), secSub.length());
                return sub + secSub;
            } else {
                secSub = "@" + "*".repeat(secSub.indexOf(".")-1) + "."
                        + "*".repeat((secSub.length() - secSub.indexOf(".")-1));
                return sub + secSub;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        System.out.println(RegexReplace.removeUnits("32cm et 50€"));
         System.out.println(RegexReplace.removeUnits("32 cm et 50 €"));
         System.out.println(RegexReplace.removeUnits("32cms et 50€!"));

         System.out.println(RegexReplace.obfuscateEmail("john.doe@example.com"));
        System.out.println(RegexReplace.obfuscateEmail("jann@example.co.org"));
         System.out.println(RegexReplace.obfuscateEmail("jackob@example.fr"));
    }
}