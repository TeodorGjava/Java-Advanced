package FilesAndStreams.ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> content = Files.readAllLines(new File(String.valueOf(path)).toPath(), Charset.defaultCharset());
        for (int i = 0; i < content.size() ; i++) {
            long sum = 0;
            for (char ch :content.get(i).toCharArray()
                 ) {
                sum+= ch;
            }
            System.out.println(sum);
        }
    }
}
