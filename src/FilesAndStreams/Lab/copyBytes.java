package FilesAndStreams.Lab;

import java.io.*;
import java.util.Scanner;
import java.util.Set;

public class copyBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Projects\\Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";
        FileInputStream file = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream("output.txt");
        int bytte = file.read();
        while (bytte != -1) {
            String digits = String.valueOf(bytte);
            if(bytte==' '){
                out.write((char)32);
            }else if (bytte==10){
                out.write((char)10);
            }else{
                for (int i = 0; i <digits.length() ; i++) {
                    out.write(digits.charAt(i));
                }
            }
            bytte = file.read();
        }
        file.close();
        out.close();
    }
}
