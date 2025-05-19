package Leetcode;

import java.util.*;
//leetcode 1436
//Time and Space Complexity =>    O(N) O(N)
public class Destination_City {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(new ArrayList<>(Arrays.asList("B", "C")));
        paths.add(new ArrayList<>(Arrays.asList("D", "B")));
        paths.add(new ArrayList<>(Arrays.asList("C", "A")));
        System.out.println(destCity(paths));
    }
    public static String destCity(List<List<String>> paths) {
        Set<String> set=new HashSet<>();
        for (List<String> path:paths) {
            set.add(path.get(0));
        }
        for (List<String> path:paths) {
            if (!set.contains(path.get(1))){
                return path.get(1);
            }
        }
        return null;
    }
}
