package FilesAndStreams.Lab;

import java.io.*;

public class copyBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Projects\\Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";
        FileInputStream file = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream("output4.txt");
        int read = file.read();
        PrintWriter writer = new PrintWriter(out);
        while (read != -1) {
            if(read==' '){
                writer.print(' ');
            }else if(read == 10){
                writer.print((char)10);
            }else{
                writer.print(read);
            }

            read = file.read();
        }
        writer.flush();
        file.close();
        out.close();
    }
}
