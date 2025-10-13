package Leetcode;

//leetcode 236
public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        // either we find one of the nodes or reach to leaf node
        if (root == null || root == p || root == q)
            return root;
        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // If both sides return non-null → current node is LCA
        // means both p and q are under this root node
        if (left != null && right != null)
            return root;

        // Otherwise return the non-null side
        return (left != null) ? left : right;
    }
}
