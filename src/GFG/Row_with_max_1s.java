package GFG;

//Complexity    O(NlogM)
public class Row_with_max_1s {
    public static void main(String[] args) {
        int[][] nums={{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
        int n=nums.length;
        int m=nums[0].length;
        System.out.println(solve(nums,n,m));
    }
    static int solve(int[][] nums,int n,int m){
        int ans=-1;
        int oldOnes=0;
        int newOnes=0;
        for (int row = n-1; row >= 0; row--) {
            if (nums[row][m-1]!=0){
                newOnes=BinarySearch(nums,row,m-1);
                if (oldOnes<=newOnes){
                    ans=row;
                    oldOnes=newOnes;
                }
            }
        }
        return ans;
    }
    private static int BinarySearch(int[][] nums,int row,int col){
        int l=0;
        int h=col;
        int idx=-1;
        //finding index of element 1 first occurrence
        while (l<=h){
            int mid=l+(h-l)/2;
            if (nums[row][mid]==1){
                idx=mid;
                h=mid-1;
            } else  {
                l=mid+1;
            }
        }
        return col-idx+1;
    }
}
