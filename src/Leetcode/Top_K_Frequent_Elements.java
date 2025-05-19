package Leetcode;

import java.util.*;
//leetcode 347
public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3,3,3};
        int k=2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
    //Time and Space Complexity =>  O(N) O(N)
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        int idx=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer>[] bucket=new ArrayList[nums.length+1];
        for (int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i:map.keySet()) {
            if (bucket[map.get(i)]==null){
                bucket[map.get(i)]=new ArrayList<>();
            }
            bucket[map.get(i)].add(i);
        }
        List<Integer> temp=new ArrayList<>();
        for (int i = bucket.length-1; i >=0 ; i--) {
            if (bucket[i]!=null){
                List<Integer> list=bucket[i];
                for (int j:list) {
                    temp.add(j);
                }
            }
        }
        while (k>0){
            k--;
            res[k]=temp.get(k);
        }
        return res;
    }
    //Method 2
    //Time and Space Complexity =>  O(NlogN) O(N)
    public static int[] topKFrequent2(int[] nums, int k) {
        int[] res=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer>[] arr=new ArrayList[nums.length+1];
        for (int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Queue<Integer> queue=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for (int key:map.keySet()) {
            queue.add(key);
            if (queue.size()>k){
                queue.poll();
            }
        }
        while (k>0){
            res[--k]=queue.poll();
        }
        return res;
    }
}
