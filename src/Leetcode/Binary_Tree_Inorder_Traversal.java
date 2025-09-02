package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  leetcode 94
//  O(N)    O(N)
public class Binary_Tree_Inorder_Traversal {
    //    Using Recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }
    void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    //    Using Iterative Approach
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;
        while(node != null || !st.isEmpty()){
            if(node!=null){
                st.push(node);
                node=node.left;
            }else{
                node=st.pop();
                list.add(node.val);
                node=node.right;
            }
        }
        return list;
    }
}
