import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        // your code here
        Month m = dateTime.getMonth();
        String frenchMonth = m.getDisplayName(TextStyle.FULL, Locale.FRANCE);

        return String.format("Le %d %s de l'an %d à %dh%dm et %ds", dateTime.getDayOfMonth(),
                frenchMonth,
                dateTime.getYear(), dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());

    }

    public static String formatSimple(LocalDate date) {
        Month m = date.getMonth();
        String it = m.getDisplayName(TextStyle.FULL, Locale.ITALIAN);
        return String.format("%s %d %d", it, date.getDayOfMonth(), date.getYear()%100);

    }

    public static String formatIso(LocalTime time) {
        // your code here
        return String.format("%d:%d:%d.00%d", time.getHour(), time.getMinute(), time.getSecond(), time.getNano());
    }

    public static void main(String[] args) {
        System.out.println(FormatDate.formatToFullText(LocalDateTime.of(2021, 8, 22, 13, 25, 46)));
        System.out.println(FormatDate.formatSimple(LocalDate.of(2022, 2, 13)));
        System.out.println(FormatDate.formatIso(LocalTime.of(16, 18, 56, 8495847)));

    }

}