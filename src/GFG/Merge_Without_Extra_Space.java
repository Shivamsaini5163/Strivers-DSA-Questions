package GFG;

public class Merge_Without_Extra_Space {
    public void mergeArrays(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        for(int i=0;i<n;i++){
            if(a[i]>b[0]){
                // swap
                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;
                // place b[0] at correct position in sorted b[]
                int first=b[0];
                int k;
                for(k=1;k<m && b[k]<first;k++){
                    b[k-1]=b[k];
                }
                b[k-1]=first;
            }
        }
    }
}
