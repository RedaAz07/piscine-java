import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length != 2) {
            return;
        }
        File input = new File(args[0]);

        FileWriter myWriter = new FileWriter(args[1]);
        try (Scanner myReader = new Scanner(input)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split("\\ ");
                StringBuilder result = new StringBuilder();
                for (String el : arr) {
                    if (el.length() == 0) {
                        return;
                    }
                    String ch = Character.toString(el.charAt(0));
                    String sub = el.substring(1);
                    String res = ch.toUpperCase() + sub.toLowerCase();
                    result.append(res);
                    result.append(" ");
                }
                myWriter.write(result.toString().trim());
                myWriter.close();

            }
        } catch (FileNotFoundException e) {
            return;
        }

    }

    public static void main(String[] args) throws IOException {
        Capitalize.capitalize(new String[] { "input", "output" });
        String expectedResult = new String(Files.readAllBytes(Paths.get("result")));
        String userOutput = new String(Files.readAllBytes(Paths.get("output")));
        System.out.println(expectedResult.equals(userOutput));
    }
}