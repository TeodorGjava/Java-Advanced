package FilesAndStreams.ex;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        FileInputStream file = new FileInputStream(String.valueOf(path));
        List<String> list = Files.readAllLines(new File(String.valueOf(path))
                .toPath(), Charset.defaultCharset());
        FileOutputStream out = new FileOutputStream("output.txt");
        PrintWriter writer = new PrintWriter(out);
        for (int i = 0; i <list.size() ; i++) {
            writer.println(i+1+". "+ list.get(i));
        }
        writer.flush();

    }
}
