package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode 145
//O(N)    O(N)
public class Binary_Tree_Postorder_Traversal {
    //    Using Recursion
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postorder(root,list);
        return list;
    }
    void postorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }
    //    Using Iterative Approach and Two Stacks
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            root=stack1.pop();
            stack2.push(root);
            if(root.left!=null){
                stack1.push(root.left);
            }
            if(root.right!=null){
                stack1.push(root.right);
            }
        }
        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;
    }
    //    Using Iterative Approach and One Stack
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        TreeNode temp=null;
        while(curr!=null||!st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }else{
                temp=st.peek().right;
                if(temp==null){
                    temp=st.peek();
                    st.pop();
                    list.add(temp.val);
                    while(!st.empty()&&temp==st.peek().right){
                        temp=st.peek();
                        st.pop();
                        list.add(temp.val);
                    }
                }else{
                    curr=temp;
                }
            }
        }
        return list;
    }
}
