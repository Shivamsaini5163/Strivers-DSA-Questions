package Leetcode;
import java.util.Stack;
//leetcode 735
//Time and Space Complexity =>    O(N) O(N)
public class Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int ast:asteroids){
            boolean alive=true;
            while(alive&&!stack.isEmpty()&&ast<0&&stack.peek()>0){
                int top=stack.peek();
                if(top>-ast){
                    alive=false;
                }else if(top==-ast){
                    stack.pop();
                    alive=false;
                }else{
                    stack.pop();
                }
            }
            if(alive){
                stack.push(ast);
            }
        }
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
