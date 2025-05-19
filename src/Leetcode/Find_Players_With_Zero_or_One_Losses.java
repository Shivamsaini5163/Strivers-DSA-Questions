package Leetcode;

import java.util.*;
//leetcode 2225
//Time and Space Complexity =>  O(N) O(N)
public class Find_Players_With_Zero_or_One_Losses {
    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(Arrays.toString(new List[]{findWinners2(matches)}));
    }
    public static List<List<Integer>> findWinners(int[][] matches) {
        ArrayList<Integer> zeroLose=new ArrayList<>();
        ArrayList<Integer> oneLose=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int[] match:matches) {
            //for example first match {1,3} 1 wins so its lose value remains as it is but 3 value get +1 in its lose record
            map.put(match[0], map.getOrDefault(match[0], 0));
            map.put(match[1],map.getOrDefault(match[1],0)+1);
        }
        for (int i:map.keySet()) {
            if (map.get(i)==0){
                zeroLose.add(i);
            } else if (map.get(i)==1) {
                oneLose.add(i);
            }
        }
        Collections.sort(zeroLose);
        Collections.sort(oneLose);
        return Arrays.asList(zeroLose,oneLose);
    }
//More Optimized Approach
    public static List<List<Integer>> findWinners2(int[][] matches) {
        int[] losses = new int[100001];
        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];
            if (losses[win] == 0) {
                losses[win] = -1;
            }
            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == -1) {
                zeroLoss.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }
        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
    }
}
