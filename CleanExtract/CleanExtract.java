public class CleanExtract {
    public static String extract(String s) {
        String[] words = s.split("\\|");
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < words.length; j++) {
            String elem = words[j].trim();
            if (elem.isEmpty()) continue;

            int firstDot = -1;
            for (int i = 0; i < elem.length(); i++) {
                if (elem.charAt(i) == '.') {
                    firstDot = i;
                    break;
                }
            }

            if (firstDot == -1) {
                result.append(elem).append(' ');
                continue;
            }

            int lastDot = -1;
            for (int i = elem.length() - 1; i >= 0; i--) {
                if (elem.charAt(i) == '.') {
                    lastDot = i;
                    break;
                }
            }

            if (firstDot == lastDot) {
                for (int i = firstDot + 1; i < elem.length(); i++) {
                    char ch = elem.charAt(i);
                    result.append(ch);
                }
            
            } else {
                for (int i = firstDot + 1; i < lastDot; i++) {
                    result.append(elem.charAt(i));
                }
            }

            result.append(' ');
        }

        return result.toString().trim().replaceAll("\\s+", " ");
    }
}