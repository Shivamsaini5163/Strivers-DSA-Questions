package GFG;

public class Minimum_Jumps {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
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
//          If after checking all indices from l to r, the farthest we can reach (maxReach) is not beyond r,
//          then we are stuck — it’s impossible to move forward, so return -1.
            if (farthest <= r) {
                // Can't move forward
                return -1;
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
}