package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Sort_according_to_an_Array {
//    Method 1
    static void relativeSort(int[] a1, int[] a2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1;
        for(int num:a2){
            map.putIfAbsent(num,rank++);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:a1) list.add(num);
        Collections.sort(list,(a, b)->{
            if(map.containsKey(a)&&map.containsKey(b)) return map.get(a)-map.get(b);
            if(map.containsKey(a)) return -1;   // a comes first, put a before b
            if(map.containsKey(b)) return 1;    // b comes first, put a after b
            return a-b; // normal sorting
        });
        for(int i=0;i<a1.length;i++) a1[i]=list.get(i);
    }

//    Method 2
    static void relativeSort2(int[] a1, int[] a2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        // Count frequency of a1
        for(int num : a1){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        // Place elements according to a2
        for(int num : a2){
            if(freq.containsKey(num)){
                int count = freq.get(num);
                while(count-- > 0){
                    a1[index++] = num;
                }
                freq.remove(num);  // remove so not processed again
            }
        }
        // Collect remaining elements
        ArrayList<Integer> remaining = new ArrayList<>();
        for(int key : freq.keySet()){
            int count = freq.get(key);
            while(count-- > 0){
                remaining.add(key);
            }
        }
        Collections.sort(remaining);
        for(int num : remaining){
            a1[index++] = num;
        }
    }
}
