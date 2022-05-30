package FilesAndStreams.ex;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class countCharsType {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        FileInputStream file = new FileInputStream(String.valueOf(path));
        List<String> list = Files.readAllLines(new File(String.valueOf(path))
                .toPath(), Charset.defaultCharset());
        FileOutputStream out = new FileOutputStream("output.txt");
        PrintWriter writer = new PrintWriter(out);
        int vowels = 0;
        int consonants = 0;
        int punct = 0;
        for (int i = 0; i < list.size(); i++) {
            for (char ch : list.get(i).toCharArray()
            ) {
                if (ch != 32) {
                    if (ch == 'a' || ch == 'o' || ch == 'e' || ch == 'i' || ch == 'u') {
                        vowels++;
                    } else if (ch == ',' || ch == '.' || ch == '?' || ch == '!') {
                        punct++;
                    } else {
                        consonants++;
                    }
                }
            }
        }
        System.out.println("Vowels: "+vowels);
        System.out.println("Consonants: "+consonants);
        System.out.println("Punctuation: "+punct);

    }
}
