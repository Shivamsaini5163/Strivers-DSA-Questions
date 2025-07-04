package GFG;

public class Check_if_there_exists_a_subsequence_with_sum_K {
//    O(2^N)      O(N)
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return check(N,arr,K,0,0);
    }
    static boolean check(int N, int[] arr, int K,int i,int sum){
        if(i==N){
            return sum==K;
        }
        if(check(N,arr,K,i+1,sum+arr[i])){
            return true;
        }
        if(check(N,arr,K,i+1,sum)){
            return true;
        }
        return false;
    }
    //If Question says to count total sequences possible 
    public int countSubsequencesWithSumK(int[] nums, int k) {
        return check(nums, k, 0, 0);
    }

    int check(int[] arr, int K, int i, int sum) {
        if (i == arr.length) {
            return (sum == K) ? 1 : 0;
        }

        // Include arr[i]
        int include = check(arr, K, i + 1, sum + arr[i]);

        // Exclude arr[i]
        int exclude = check(arr, K, i + 1, sum);

        return include + exclude;
    }
}
