package FilesAndStreams.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class writeToFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path = "D:\\Projects\\Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";
        FileInputStream file = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream("output.txt");
        //accessing a file from memory
        int bytte = file.read();
        Set<Character> punctuation = Set.of(',', '.', '!', '?');
        PrintWriter writer = new PrintWriter(out);
        while (bytte != -1) {
            if (!punctuation.contains((char) bytte)) {
                out.write((char) bytte);
            }
            bytte = file.read();
        }
    }
}
