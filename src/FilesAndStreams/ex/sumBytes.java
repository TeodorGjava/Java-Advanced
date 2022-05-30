package FilesAndStreams.ex;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class sumBytes {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> content = Files.readAllLines(new File(String.valueOf(path)).toPath(), Charset.defaultCharset());
        long sum = 0;
        for (int i = 0; i < content.size() ; i++) {
            for (char ch :content.get(i).toCharArray()
            ) {
                sum+= ch;
            }
        }
        System.out.println(sum);
    }
}
