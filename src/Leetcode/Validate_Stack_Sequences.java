package Leetcode;

import java.util.Stack;
//leetcode 946
//Time and Space Complexity =>    O(N) O(1)
public class Validate_Stack_Sequences {
    // using stack which takes O(N) space
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int j=0;    //this pointer is used to trace element in popped array
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    //it is more optimized which takes O(1) space and use that stack technique in same pushed array
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int n=pushed.length;
        int j=0;
        int k=-1;
        for(int i=0;i<n;i++){
            pushed[++k]=pushed[i];
            while(k>=0&&pushed[k]==popped[j]){
                k--;
                j++;
            }
        }
        return k==-1;
    }
}
