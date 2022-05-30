package FilesAndStreams.ex;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CapitalLETERS {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        FileInputStream file = new FileInputStream(String.valueOf(path));
        List<String> list = Files.readAllLines(new File(String.valueOf(path)).toPath(), Charset.defaultCharset());
        FileOutputStream out = new FileOutputStream("output.txt");
        PrintWriter writer = new PrintWriter(out);
        for (int i = 0; i <list.size() ; i++) {
            writer.println(list.get(i).toUpperCase(Locale.ROOT));
        }
        writer.flush();

    }
}
