/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdastream;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

/**
 *
 * @author ssoch
 */
public class LambdaStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

//        Map<String, Integer> map = new HashMap<>();
//        Files.lines(Paths.get("res/bilety.txt")).forEach(
//                x -> {
//                    if (map.containsKey(x.split(",")[2])) {
//                        Integer tickets = Integer.sum(map.get(x.split(",")[2]), Integer.parseInt(x.split(",")[0]));
//                        map.put(x.split(",")[2], tickets);
//                    } else {
//                        map.put(x.split(",")[2], Integer.parseInt(x.split(",")[0]));
//                    }
//                }
//        );
//        map.forEach((x, y) -> System.out.println(x + " - " + y));
//
//
//
//    Files.lines(Paths.get("res/bilety.txt"))
//            .map(line -> {
//                String[] tmp = line.split(","); 
//                return new Item(Integer.parseInt(tmp[0]), tmp[1], tmp[2]);
//            })
//            .collect(groupingBy(x -> x.getCity(), Collectors.mapping(x -> x.getOfferer(), toSet())))
//            .forEach((x,y) -> System.out.println(x + " - " + y));
//    }
//
//
//
        Files.lines(Paths.get("res/bilety.txt")).map(line -> {
            String[] tmp = line.split(",");
            return new Item(Integer.parseInt(tmp[0].trim()), tmp[1].trim(), tmp[2].trim());
        }).collect(
                () -> {
                    Map<String, Result> tempResult = new HashMap<>();
                    return tempResult;
                }, (teapMap, item) -> {
                    Result result = teapMap.get(item.getCity());
                    if (result == null) {
                        result = new Result();                        
                        teapMap.put(item.getCity(), result);
                    }
                    result.putOfferers(item.getOfferer());
                    result.addTickets(item.getQuantity());
                }, (map1, map2) -> {
                    map1.putAll(map2);
                }
        ).forEach((x, y) -> System.out.println(x + " ; " + y));



//        Stream<String> lines = Files.lines(Paths.get("res/bilety.txt"));
//
//        Stream<Item> items = lines.map(line -> {
//            String[] tmp = line.split(",");
//            return new Item(Integer.parseInt(tmp[0].trim()), tmp[1].trim(), tmp[2].trim());
//        }).filter(x -> x.getOfferer().startsWith("A"));
//
//        Map<String, Result> resultMap = items.collect(
//                () -> {
//                    Map<String, Result> tempResult = new HashMap<>();
//                    return tempResult;
//                }, (teapMap, item) -> {
//                    Result result = teapMap.get(item.getCity());
//                    if (result == null) {
//                        result = new Result();                        
//                        teapMap.put(item.getCity(), result);
//                    }
//                    result.putOfferers(item.getOfferer());
//                    result.addTickets(item.getQuantity());
//                }, (map1, map2) -> {
//                    map1.putAll(map2);
//                }
//        );
//        
//        resultMap.forEach((x, y) -> System.out.println(x + " - " + y));
    }
}
