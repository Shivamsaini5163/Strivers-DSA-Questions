package Leetcode;

public class Balanced_Binary_Tree {
//    Complexity =>   O(N^2)    O(N)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;
    }
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    //    Complexity =>   O(N)    O(N)  Optimized Approach
    public boolean isBalanced2(TreeNode root) {
        return getHeight2(root) != -1;
    }
    public int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1; // left subtree unbalanced

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1; // right subtree unbalanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // not balanced

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
