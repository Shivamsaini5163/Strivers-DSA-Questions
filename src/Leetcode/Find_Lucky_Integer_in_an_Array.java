package Leetcode;
//leetcode 1394
//Time and Space Complexity =>    O(N) O(K)
public class Find_Lucky_Integer_in_an_Array {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }
    public static int findLucky(int[] arr) {
        int[] count=new int[501];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for(int i=count.length-1;i>=1;i--){
            if(i==count[i]){
                return i;
            }
        }
        return -1;
    }
}
