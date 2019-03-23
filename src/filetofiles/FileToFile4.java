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
import java.util.List;

/**
 *
 * @author ssoch
 */
public class FileToFile4 {

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

        private static List<FileWriterInfo> fileWriterInfo = new ArrayList<>();
        public static int fileAmount = 3;

        private static FileWriter getNextFileWriter() {

            fileWriterInfo.sort((x, y) -> x.getCounter().compareTo(y.getCounter()));

            return getFileWriter();
        }

        private static FileWriter getFileWriter() {
            if (fileWriterInfo.isEmpty()) {
                init();
            }

            FileWriterInfo get = fileWriterInfo.get(0);
            get.increment();
            return fileWriterInfo.get(0).getFilesWtriter();
        }

        private static void closeFileWriter() {
            for (FileWriterInfo fw : fileWriterInfo) {
                try {
                    fw.getFilesWtriter().close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            fileWriterInfo.clear();
        }

        private static void init() {
            for (int i = 0; i < fileAmount; i++) {
                try {
                    FileWriter fw = new FileWriter("res/plik_" + i + ".txt");
                    fileWriterInfo.add(new FileWriterInfo(fw));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }

    }

}
