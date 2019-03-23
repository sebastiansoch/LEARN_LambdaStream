/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetofiles;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author ssoch
 */
public class FileToFile2 {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("res/bilety.txt"))
                .forEach(x -> {
                    FileWriter fw = FileWriterFactory.getFileWriter(x.split(",")[2].trim());
                    save(fw, x);
                });

        FileWriterFactory.closeFileWriter();
    }

    private static void save(FileWriter fileWriter, String x) {

        System.out.println(x);

        try {
            fileWriter.append(x + "\n");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static class FileWriterFactory {

        private static Map<String, FileWriter> filesWtriter = new HashMap<>();

        private static FileWriter getFileWriter(String t) {

            FileWriter fw = filesWtriter.get(t);
            if (fw == null) {
                try {
                    fw = new FileWriter("res/" + t + ".txt");
                    filesWtriter.put(t, fw);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            return fw;
        }

        private static void closeFileWriter() {
            for (String key : filesWtriter.keySet()) {
                try {
                    filesWtriter.get(key).close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            filesWtriter.clear();
        }

    }
}
