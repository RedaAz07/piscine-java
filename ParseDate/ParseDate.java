import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate== null)  return null;
        return LocalDateTime.parse(stringDate);        
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        
        if (stringDate == null) return null;

       DateTimeFormatter formatter =
        new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("EEEE d MMMM yyyy")
                .toFormatter(Locale.ENGLISH);

        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
          if (stringDate== null)  return null;
        // your code 
       
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("hh 'hours' B, mm 'minutes and' ss 'seconds'");

        LocalTime date = LocalTime.parse(stringDate, formatter); 
        return date;   
    }
      public static void main(String[] args) {
        System.out.println(ParseDate.parseIsoFormat("2022-04-25T20:51:28.709039322"));
   System.out.println(ParseDate.parseFullTextFormat("monday 25 april 2022"));
        System.out.println(ParseDate.parseTimeFormat("09 hours in the evening, 07 minutes and 23 seconds"));
    }

}