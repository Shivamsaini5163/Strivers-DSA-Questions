package GFG;

public class Number_of_greater_elements_to_the_right {
    // Complexity =>    O(q × n)    O(q)
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] res=new int[queries];
        for(int i=0;i<queries;i++){
            int count=0;
            for(int j=indices[i]+1;j<N;j++){
                if(arr[indices[i]]<arr[j]) {
                    count++;
                }
            }
            res[i]=count;
        }
        return res;
    }
}
