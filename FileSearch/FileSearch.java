import java.io.File;
import java.io.IOException;

public class FileSearch {
    public static String searchFile(String fileName) {
        // your code here
        File file = new File(fileName);
        String absoluteFile = file.getAbsoluteFile().toString();
        int indx = absoluteFile.indexOf("documents");
        return absoluteFile.toString().substring(indx);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(FileSearch.searchFile("file.txt"));
    }
}