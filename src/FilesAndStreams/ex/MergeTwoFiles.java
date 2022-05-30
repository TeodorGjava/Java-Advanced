package FilesAndStreams.ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path path2 = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        FileInputStream file = new FileInputStream(String.valueOf(path));
        List<String> firstFile = Files.readAllLines(new File(String.valueOf(path)).toPath(), Charset.defaultCharset());
        List<String> secondFile = Files.readAllLines(new File(String.valueOf(path2)).toPath(), Charset.defaultCharset());
        List<String> finalList = new ArrayList<>(firstFile);
        finalList.addAll(secondFile);
        for (String s : finalList) {
            System.out.println(s);
        }
    }
}
