package Advanced.FilesAndStreams.Lab;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        FileInputStream file = new FileInputStream(String.valueOf(path));
        List<String> list = Files.readAllLines(new File(String.valueOf(path)).toPath(), Charset.defaultCharset() );
        System.out.println();
        FileOutputStream out = new FileOutputStream("output.txt");
        PrintWriter writer = new PrintWriter(out);
        Collections.sort(list);
        for (int i = 0; i <list.size() ; i++) {
            writer.println(list.get(i));
        }
        writer.flush();

    }
}
