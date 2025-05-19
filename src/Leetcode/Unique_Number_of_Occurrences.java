package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
//leetcode 1207
//Time and Space Complexity =>    O(N) O(N)
public class Unique_Number_of_Occurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> set=new HashSet<>();
        for (int i:map.keySet()) {
            int j=map.get(i);
            if (set.contains(j)){
                return false;
            }
            set.add(j);
        }
        return true;
    }
}
