package GFG;

public class Sum_of_Subarrays {
//    Brute Force O(N^2)
    public int subarraySum(int[] arr) {
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int temp=0;
            for(int j=i;j<n;j++){
                temp+=arr[j];
                sum+=temp;
            }
        }
        return sum;
    }
//    Optimize Approach O(N)
public int subarraySum2(int[] arr) {
    int sum=0;
    int n=arr.length;
    for(int i=0;i<n;i++){
        sum+=arr[i]*(i+1)*(n-i);    //formula to find number of subarray
    }
    return sum;
}
//    Intuition:
//    eg: arr[]={0,1,2,3,4,5}
//    for arr[3]:
//    i + 1 = 3 + 1 = 4 → ways to choose start index (0,1,2,3)
//    n - i = 6 - 3 = 3 → ways to choose end index (3,4,5)
}
