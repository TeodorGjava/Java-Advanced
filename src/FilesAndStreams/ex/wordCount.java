package FilesAndStreams.ex;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class wordCount {
    public static void main(String[] args) throws IOException {
        Path path = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path path2 = Path
                .of("C:\\TEO\\Java-Advanced\\Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        FileInputStream file = new FileInputStream(String.valueOf(path));
        List<String> listWords = Files.readAllLines(new File(String.valueOf(path)).toPath(), Charset.defaultCharset());
        List<String> listText = Files.readAllLines(new File(String.valueOf(path2)).toPath(), Charset.defaultCharset());
        FileOutputStream out = new FileOutputStream("output.txt");
        PrintWriter writer = new PrintWriter(out);
        Map<String, Integer> repetitions = new LinkedHashMap<>();
        int z = 0;
        String[] words = listWords.get(z).split(" ");
        for (int i = 0; i <words.length; i++, z++) {
            String[] row = listText.get(0).split(" ");
            for (int j = 0; j <row.length ; j++) {
                if(row[j].equals(words[i])){
                    repetitions.putIfAbsent(row[j],0);
                    repetitions.put(row[j],repetitions.get(row[j])+1);
                }
            }
        }
        repetitions.entrySet().stream().sorted((x,y)->y.getValue().compareTo(x.getValue())).forEach(x-> System.out.println(x.getKey()+" - "+x.getValue()));
    }
}
