import java.io.File;

public class FileSearch {

    public static String searchFile(String fileName) {
        File root = new File("documents");
        if (!root.exists() || !root.isDirectory()) return null;

        File found = searchRecursive(root, fileName);
        return (found == null) ? null : found.getPath();
    }

    private static File searchRecursive(File dir, String fileName) {
        File[] items = dir.listFiles();
        if (items == null) return null;

        for (File item : items) {
            if (item.isFile() && item.getName().equals(fileName)) {
                return item;
            }
            if (item.isDirectory()) {
                File found = searchRecursive(item, fileName);
                if (found != null) return found;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(searchFile("file.txt"));
    }
}