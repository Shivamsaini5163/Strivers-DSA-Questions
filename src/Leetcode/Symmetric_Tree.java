package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

//leetcode 101
public class Symmetric_Tree {
    // Iterative method
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            // enqueue in mirrored order
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    // Recursive method
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // both null → symmetric
        if (t1 == null && t2 == null) return true;
        // only one is null → not symmetric
        if (t1 == null || t2 == null) return false;

        // check values and mirror structure
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
