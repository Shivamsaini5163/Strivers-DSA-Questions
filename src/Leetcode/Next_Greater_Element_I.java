package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
//leetcode 496
public class Next_Greater_Element_I {
    //Method 1
    //Time and Space Complexity => O(N) O(N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.fill(res,-1);
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty()&&nums2[i]>st.peek()){
                map.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])){
                res[i]=map.get(nums1[i]);
            }
        }
        return res;
    }
    //Method 2
    //this approach takes O(N^2) time and O(N) space
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.fill(res,-1);
        for(int i=0;i<nums2.length;i++){    //storing of nums2 element index in map so that we can directly jump to that
            map.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++){
            int ele=nums1[i];
            for(int j=map.get(ele);j<nums2.length;j++){
                if(nums2[j]>ele){
                    res[i]=nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
