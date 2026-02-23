import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.IIOException;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        // your code here
        try {
            File file = new File(fileName);

            if (file.createNewFile()) {
                FileWriter fl = new FileWriter(file);
                fl.write(content);
                fl.close();
            }
        } catch (IIOException e) {
            return;
        }
    }

    public static String getContentFile(String fileName) throws IOException {
        File file = new File(fileName);
        StringBuilder res = new StringBuilder();
        try (Scanner scann = new Scanner(file)) {

            while (scann.hasNextLine()) {
                String data = scann.nextLine();
                res.append(data);
                res.append("\n");
            }
            return res.toString().trim();
        }
    }
    public static void deleteFile(String fileName) {
        // your code here
        File myObj = new File(fileName);
        myObj.delete();

    }

    public static void main(String[] args) throws IOException {
        String testString ="""
                    This file has many lines
                    Here is the second.
                    And there is the 3rd !""";
        FileManager.createFile("file.txt", testString);
        System.out.println(FileManager.getContentFile("file.txt"));
        FileManager.deleteFile("file.txt");
    }
}