package Java_8_features.stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {
    public static void main(String[] args) {
        List<Integer> list1=List.of(2,4,50,21,22,67);
        List<Integer> even=new ArrayList<>();
        for (Integer i:list1) {
            if (i%2==0){
                even.add(i);
            }
        }
//        System.out.println(list1);
//        System.out.println(even);
        // using stream
        Stream<Integer> stream=list1.stream();
        List<Integer> newList=stream.filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(newList);
    }
}
