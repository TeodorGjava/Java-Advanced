package FilesAndStreams.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class nestedFolders {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File file = new File(String.valueOf(path));
        FileOutputStream out = new FileOutputStream("output.txt");
        File[] files = file.listFiles();
        PrintWriter writer = new PrintWriter(out);
        List<String> fileList = new ArrayList<>();
        int counter = 0;
        for (File f : files
        ) {
            if (!f.getName().contains(".")) {
                fileList.add(f.getName());
                counter++;
            }
            if (f.isDirectory()) {
                File[] files1 = f.listFiles();
                for (int i = 0; i < files1.length; i++) {
                    if (!files1[i].getName().contains(".")) {
                        fileList.add(files1[i].getName());
                        counter++;
                    }
                    if (files1[i].isDirectory()) {
                        File[] files2 = files1[i].listFiles();
                        for (File f2 : files2
                        ) {
                            if (!f2.getName().contains(".")) {
                                fileList.add(f2.getName());
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        for (String s : fileList
        ) {
            writer.println(s);
        }
        writer.println(counter);
        writer.flush();
    }
}
