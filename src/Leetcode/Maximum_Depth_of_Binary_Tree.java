package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

//leetcode 104
//Complexity =>   O(N) O(N)
public class Maximum_Depth_of_Binary_Tree {
    // Using Recursion (DFS)
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return Math.max(lh,rh)+1;
    }
    // Using Iteration (BFS)
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }
}
