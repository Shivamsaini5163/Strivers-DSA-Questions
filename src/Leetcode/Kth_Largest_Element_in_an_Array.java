package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode 215
public class Kth_Largest_Element_in_an_Array {
    //Brute Force O(NlogN)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    //Better Approach   using Min-Heap O(NlogK)
    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> minHeap=new PriorityQueue<>();
        //operate all operations on smallest element
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    //Optimized Approach    using Quick Selection Algorithm

}
