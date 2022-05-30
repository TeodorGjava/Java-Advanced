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
        FileOutputStream out = new FileOutputStream("output2.txt");

        int read = file.read();
        while (read != -1){
           String output = Integer.toBinaryString(read)+" ";
            for (char c : output.toCharArray()) {
                out.write(c);
            }
            read = file.read();
        }

    }
}
