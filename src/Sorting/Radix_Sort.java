package Sorting;
///Time and Space complexity is O(d*N) and O(N)
//Not inplace sorting algorithm but it is stable
import java.lang.reflect.Array;
import java.util.Arrays;

public class Radix_Sort {
    public static void main(String[] args) {
        int[] arr={29,83,471,36,91,8};
        radix_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void radix_sort(int[] arr){
        //do count sort for every digit place
        int max=Arrays.stream(arr).max().getAsInt();
        for (int exp=1;max/exp>0;exp*=10) {
            count_sort(arr,exp);
        }
    }
    private static void count_sort(int[] arr,int exp){
        //simply use count sort for each digit from ones digit place to max one
        int n= arr.length;
        int[] output=new int[n];
        int[] count=new int[10];
        Arrays.fill(count,0);
        for (int i = 0; i < n; i++) {
            count[arr[i]/exp%10]++;
        }
        for (int i = 1; i <10 ; i++) {
            count[i]+=count[i-1];
        }
        for (int i = n-1; i >=0 ; i--) {
            output[count[arr[i]/exp%10]-1]=arr[i];
            count[arr[i]/exp%10]--;
        }
        System.arraycopy(output,0,arr,0,arr.length);
    }
}
