package Leetcode;
import java.util.Stack;
//leetcode 735
//Time and Space Complexity =>    O(N) O(N)
public class Asteroid_Collision {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack=new Stack<>();
        boolean shouldPush;//by default it is false
        for(int i=0;i<a.length;i++){
            shouldPush=true; //first make it true of every coming element
            while(!stack.isEmpty()){
                int peek=stack.peek();
                //first is + second is - and both are equal they collide and kill each other
                if(peek>0&&peek==a[i]*-1){
                    stack.pop();
                    shouldPush=false;
                    break;
                }   //equal sign orr 1st is -ve and second is +ve   that means no collision
                else if(peek*a[i]>0||peek<0&&a[i]>0){
                    break;
                }
                // it catches +ve -ve case when they are not equal
                // it means in coming will get destroy so no need to add it in stack
                else if(peek>Math.abs(a[i])){
                    shouldPush=false;
                    break;
                }
                // it catches +ve -ve case when they are not equal
                //we are not using break here because we want continue pop as it can
                //it means stack top gets destroy but we still wat to check is it okay to add incoming element into stack so we continue with while loop
                else if(peek<Math.abs(a[i])){
                    stack.pop();
                }
            }
            if(shouldPush){
                stack.push(a[i]);
            }
        }
        //copy stack to array
        int[] res=new int[stack.size()];
        int k=0;
        for(int i:stack){
            res[k++]=i;
        }
        return res;
    }
}
