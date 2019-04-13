/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetofiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 *
 * @author ssoch
 */
public class PolicyPrintout {

//    public static void main(String[] args) throws IOException {
//        Files.lines(Paths.get("res/policy.txt"))
//                .map(x -> new Policy(Integer.parseInt(x.split(",")[0].trim()),
//                        Integer.parseInt(x.split(",")[1].trim()), 
//                        Integer.parseInt(x.split(",")[2].trim())))
//                .collect(Collectors.groupingBy(x -> x.getStatus()))
//                .forEach((x, y) -> {
//                    y.sort((q, w) -> (-1) * Integer.compare(q.getPrice(), w.getPrice()));
//                    System.out.println(x);
//                    y.forEach(z -> System.out.println(z));
//                });
//    }
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("res/policy.txt"))
                .map(x -> new Policy(Integer.parseInt(x.split(",")[0].trim()),
                Integer.parseInt(x.split(",")[1].trim()),
                Integer.parseInt(x.split(",")[2].trim())))
                .collect(Collectors.groupingBy(x -> x.getStatus())).entrySet().stream()
                .peek(x -> x.getValue().sort((q, w) -> (-1) * Integer.compare(q.getPrice(), w.getPrice())))
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().forEach(z -> System.out.println(z));
                });

    }

}
