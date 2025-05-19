package Leetcode;
//leetcode 3005
public class Count_Elements_With_Maximum_Frequency {
    public int maxFrequencyElements(int[] arr) {
        int n=arr.length;
        int[] res=new int[101];
        for(int i=0;i<n;i++){
            res[arr[i]]++;
        }
        //finding max frequency
        int maxFreq=0;
        for(int i=1;i<=100;i++){
            maxFreq=Math.max(maxFreq,res[i]);
        }
        //count those elements which have same freq
        int count=0;
        for(int i=1;i<=100;i++){
            if(maxFreq==res[i]){
                count+=maxFreq;
            }
        }
        return count;
    }
}
