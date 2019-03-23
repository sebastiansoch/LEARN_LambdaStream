/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetofiles;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssoch
 */
class FileWriterInfo {
    final private FileWriter filesWtriter;
    private Integer counter = 0;

    public FileWriterInfo(FileWriter filesWtriter) {
        this.filesWtriter = filesWtriter;
    }

    public FileWriter getFilesWtriter() {
        return filesWtriter;
    }

    public Integer getCounter() {
        return counter;
    }

    void increment() {
        ++counter;
    }
    
}
