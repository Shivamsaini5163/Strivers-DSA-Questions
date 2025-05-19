package Leetcode;

import java.util.HashMap;
//leetcode 2260
//Time and Space Complexity =>  O(N) O(N)
public class Minimum_Consecutive_Cards_to_Pick_Up {
    public static void main(String[] args) {
        int[] cards = {8,2,3,4,7,8};
        System.out.println(minimumCardPickup(cards));
    }
    public static int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])){
                ans=Math.min(ans,i-map.get(cards[i])+1);
            }
            map.put(cards[i],i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
