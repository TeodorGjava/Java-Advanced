package FilesAndStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class readFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path = "D:\\Projects\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream file = new FileInputStream(path);
        //accessing a file from memory
        int bytte = file.read();
        while (bytte != -1) {
            //bytes of the file
            System.out.print(Integer.toBinaryString(bytte)+" ");
            //cast to char returns the original text

            bytte = file.read();
    }
    }
}
