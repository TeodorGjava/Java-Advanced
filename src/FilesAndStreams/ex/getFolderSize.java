package FilesAndStreams.ex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class getFolderSize {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\");
        File file = new File(String.valueOf(path));
        File[] files = file.listFiles();
        long bytes = 0;
        for (File file1 : files) {
            if(file1.isDirectory()){
                bytes = Files.size(Path.of(file1.getPath()));
            }
        }
        System.out.println(bytes);

    }
}
