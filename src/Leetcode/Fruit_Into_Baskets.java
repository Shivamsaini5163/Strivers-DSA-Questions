package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode 904
public class Fruit_Into_Baskets {
    //Brute Force O(N^2)    O(3)
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(fruits[j]);
                if(set.size()<=2){
                    maxLen=Math.max(maxLen,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }
    //Optimize Approach  O(2*N) )   O(3)
    public int totalFruit2(int[] fruits) {
        int n=fruits.length;
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        for(int right=0;right<n;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
    //More Optimize Approach  O(N) )   O(3)
    public int totalFruit3(int[] fruits) {
        int n=fruits.length;
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        for(int right=0;right<n;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            if(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            if (map.size()<=2){
                maxLen=Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }
}
