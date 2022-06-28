package Advanced.FilesAndStreams.Lab;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class listFiles {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File file = new File(String.valueOf(path));
        FileOutputStream out = new FileOutputStream("output.txt");
        File[] files = file.listFiles();
        PrintWriter writer = new PrintWriter(out);
        for (int i = 0; i < files.length; i++) {
            long bytes = Files.size(Path.of(files[i].getPath()));
            if (files[i].getName().contains(".")) {
                System.out.println(files[i].getName() + ": [" + bytes + "]");
                writer.println(files[i].getName() + ": [" + bytes + "]");
            }
        }
        writer.flush();


    }
}
