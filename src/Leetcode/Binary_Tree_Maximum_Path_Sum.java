package Leetcode;

//leetcode 124
public class Binary_Tree_Maximum_Path_Sum {
    private int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode root){
        if(root==null) return 0;
        // Recursively get max path sum of left and right subtrees
        // and don't consider negative nodes take 0 for them
        int leftGain=Math.max(maxGain(root.left),0);
        int rightGain=Math.max(maxGain(root.right),0);
        // Path including both children
        int newPathValue=root.val+leftGain+rightGain;
        // Update global max
        maxSum=Math.max(maxSum,newPathValue);
        // Return the max gain from one side + current node
        return root.val+Math.max(leftGain,rightGain);
    }
}
