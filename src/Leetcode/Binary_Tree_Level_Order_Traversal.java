package Leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//leetcode 102
//Complexity =>   O(N)    O(N)
public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root == null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size(); // number of nodes in current level
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(level); // add current level to result
        }
        return ans;
    }
}
