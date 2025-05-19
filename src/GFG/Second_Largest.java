package GFG;

public class Second_Largest {
    public int getSecondLargest(int[] arr) {
        // Code Here
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
}
