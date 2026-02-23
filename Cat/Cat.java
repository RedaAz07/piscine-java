import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        // your code here
        if (args.length != 1) {
            return;
        }
        FileReader myFile = new FileReader(args[0]);
        try (BufferedReader reader = new BufferedReader(myFile)) {
            while (reader.readLine() != null) {
                System.out.print(reader.readLine());
            }
        } catch (Exception e) {
            return;
        }

    }

    public static void main(String[] args) throws IOException {
        PrintStream stdout = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Cat.cat(new String[] { "input.txt" });
        String output = outputStream.toString();
        // Reset out to stdout
        System.setOut(stdout);
        System.out.println(output.equals("test input file\n"));

        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
        PrintStream printStream2 = new PrintStream(outputStream2);
        System.setOut(printStream2);

        Cat.cat(new String[] {});
        String output2 = outputStream2.toString();
        // Reset out to stdout
        System.setOut(stdout);
        System.out.println(output2.equals(""));
    }
}