import java.util.*;


public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
   Map<String, String> matches = new HashMap<>();

        Set<String> freeMen = new HashSet<>(first.keySet());

        Map<String, String> womenPartners = new HashMap<>();

        while (!freeMen.isEmpty()) {
            String man = freeMen.iterator().next();

            List<String> women = first.get(man);

            for (String woman : women) {
                if (!womenPartners.containsKey(woman)) {
                    womenPartners.put(woman, man);
                    matches.put(man, woman);
                    freeMen.remove(man);  
                    break;
                } else {
                    String currentPartner = womenPartners.get(woman);
                    List<String> womanPreferences = second.get(woman);

                    if (womanPreferences.indexOf(man) < womanPreferences.indexOf(currentPartner)) {
                        womenPartners.put(woman, man);
                        matches.put(man, woman);
                        freeMen.remove(man);
                        freeMen.add(currentPartner); 
                        break;
                    }
                }
            }
        }

        return matches;
    }
     public static void main(String[] args) {
        System.out.println(WeddingComplex.createBestCouple(
                Map.of("Naruto", List.of("Sakura", "Hinata"), "Sasuke", List.of("Sakura", "Hinata")),
                Map.of("Sakura", List.of("Sasuke", "Naruto"), "Hinata", List.of("Naruto", "Sasuke"))));
    }
}