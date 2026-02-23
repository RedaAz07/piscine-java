import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        // your code here
        if (args.length != 1) {
            return;
        }
        File myFile = new File(args[0]);
        try (InputStream in = new BufferedInputStream(new FileInputStream(myFile))) {
            OutputStream out = System.out; 
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
            out.flush();
        } catch (IOException e) {
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