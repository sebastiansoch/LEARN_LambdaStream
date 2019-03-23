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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ssoch
 */
public class FileToFile3 {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("res/order.txt"))
                .forEach(x -> {
                    FileWriter fileWriter = FileWriterFactory.getFileWriter();
                    if (x.startsWith("ORDER")) {
                        fileWriter = FileWriterFactory.getNextFileWriter();
                    }
                    save(fileWriter, x);

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

        private static List<FileWriter> filesWtriter = new ArrayList<>();
        public static int fileAmount = 3;
        private static int iterator = 0;
        private static Map<Integer, Integer> counter = new HashMap<>();

        private static FileWriter getNextFileWriter() {

            Integer aa = Integer.MAX_VALUE;
            for (Integer i : counter.keySet()) {
                if (counter.get(i) < aa) {
                    aa = counter.get(i);
                    iterator = i;
                }
            }

            return getFileWriter();
        }

        private static FileWriter getFileWriter() {
            if (filesWtriter.isEmpty()) {
                init();
            }

            Integer get = counter.get(iterator);
            counter.replace(iterator, ++get);

            return filesWtriter.get(iterator);
        }

        private static void closeFileWriter() {
            for (FileWriter fw : filesWtriter) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            filesWtriter.clear();
        }

        private static void init() {
            for (int i = 0; i < fileAmount; i++) {
                try {
                    FileWriter fw = new FileWriter("res/plik_" + i + ".txt");
                    filesWtriter.add(fw);
                    counter.put(i, 0);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }

    }
}
