package Leetcode;
//leetcode 45
//Time and Space Complexity => O(N) O(1)
public class Jump_Game_II {
    public int jump(int[] arr) {
        int n=arr.length;
        if (n <= 1) return 0; // No jumps needed if array has one element
        if (arr[0] == 0) return -1; // Cannot move forward if the first element is 0
        int jumps=0;
        int l=0;
        int r=0;
        int farthest=0;
        while(r<n-1){
            for(int i=l;i<=r;i++){
                farthest=Math.max(i+arr[i],farthest);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
}
