package GFG;

import java.util.ArrayList;
import java.util.List;

public class Minimum_number_of_Coins {
    //Complexity =>   O(N)    O(N)
    static List<Integer> minPartition(int N) {
        int[] arr={1,2,5,10,20,50,100,200,500,2000};
        List<Integer> list=new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            while(arr[i]<=N){
                list.add(arr[i]);
                N-=arr[i];
            }
        }
        return list;
    }
    //Slightly Better
    //Complexity =>   O(N)    O(N)
    static List<Integer> minPartition2(int N) {
        int[] arr={1,2,5,10,20,50,100,200,500,2000};
        List<Integer> list=new ArrayList<>();
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] <= N) {
                int count = N / arr[i];
                for (int j = 0; j < count; j++) list.add(arr[i]);
                N %= arr[i];
            }
        }
        return list;
    }
}
