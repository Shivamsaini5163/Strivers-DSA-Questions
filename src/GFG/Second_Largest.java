package GFG;

public class Second_Largest {
//    NOTE: We are Finding distinct second largest number
    public int getSecondLargest(int[] arr) {
        int n=arr.length;
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }else if(second<arr[i]&&first!=arr[i]){
                second=arr[i];
            }
        }
        return second==Integer.MIN_VALUE?-1:second;
    }
    //  OR
    public int getSecondLargest2(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            // skip duplicates of the largest
            if (num == first) continue;

            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }
}
