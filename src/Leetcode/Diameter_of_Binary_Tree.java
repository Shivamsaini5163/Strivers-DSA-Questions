package Leetcode;

//  leetcode 543
//  O(N)    O(N)
public class Diameter_of_Binary_Tree {
    private int diameter=0; // global variable
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root); // start recursion
        return diameter; // return the maximum diameter found
    }
    // Recursive function to calculate depth of the tree
    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0; // base case: empty node has depth 0
        }

        // Recursively find depth of left and right subtrees
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        // The diameter at this node is leftDepth + rightDepth
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return the depth of this node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
