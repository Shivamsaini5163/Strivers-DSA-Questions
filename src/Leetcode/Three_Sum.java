package Leetcode;

import java.util.List;
import java.util.*;
//leetcode 15
public class Three_Sum {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    //Brute force O(N^3)
    public static List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> st = new HashSet<>();
        int n=arr.length;
        // check all possible triplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    //More Optimized O(N^2*logM)    Space O(N)
    public List<List<Integer>> threeSum2(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hashset=new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third=-1*(arr[i]+arr[j]);
                if(hashset.contains(third)){
                    List<Integer> temp=Arrays.asList(arr[i],arr[j],third);
                    temp.sort(null);
                    set.add(temp);
                }
                hashset.add(arr[j]);
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    //Best Approach O(N^2)    Space O(1)
    public List<List<Integer>> threeSum3(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            //Skip duplicates
            if(i!=0&&arr[i]==arr[i-1]) continue;
            int k=n-1;
            int j=i+1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k]);
                    list.add(temp);
                    j++;
                    k--;
                    //Skip duplicates
                    while(j<k&&arr[j]==arr[j-1]) j++;
                    while(j<k&&arr[k]==arr[k+1]) k--;
                }
            }
        }
        return list;
    }
}
