package Leetcode;

//    leetcode 1423
public class Maximum_Points_You_Can_Obtain_from_Cards {
//    Complexity =>  O(K)  O(1)
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int l=n;
        int r=n+k-1;
        int sum=0;
        // initial sum of k cards
        for(int i=l;i<=r;i++){
            sum+=cardPoints[i%n];
        }
        k--;
        int maxPoint=sum;
        // sliding window across k choices
        while(k>=0){
            sum-=cardPoints[r%n];
            r--;
            l--;
            sum+=cardPoints[l%n];
            maxPoint=Math.max(maxPoint,sum);
            k--;
        }
        return maxPoint;
    }
}
