package GFG;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree_Boundary_Traversal {
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
                                                                // Solution
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null) return result;
        result.add(root.data);

        // Add left boundary excluding leaf nodes
        addLeft(root.left, result);

        // Add leaf nodes (make sure if root is also leaf node then exclude it because root is already gets used)
        addLeaves(root, result, root);

        // Add right boundary in reverse excluding leaf nodes
        addRight(root.right, result);

        return result;
    }
    private void addLeft(Node node, List<Integer> result) {
        while(node!=null){
            if(node.left != null || node.right != null){ // make sure its not leaf node
                result.add(node.data);
            }
            node = (node.left != null) ? node.left : node.right; //go to left if possible otherwise go right
        }
    }
    private void addLeaves(Node node, List<Integer> result, Node root) {
        if (node == null) return;
        if (node.left == null && node.right == null) { // make sure its leaf node
            if (node != root){ // Only add leaf if it's not root, avoid root duplication
                result.add(node.data);
            }
            return;
        }
        addLeaves(node.left, result, root);
        addLeaves(node.right, result, root);
    }
    private void addRight(Node node, List<Integer> result) {
        Stack<Integer> stack = new Stack<>(); // to take reverse order
        while (node != null) {
            if (node.left != null || node.right != null) // make sure its not leaf node
                stack.push(node.data);
            node = (node.right != null) ? node.right : node.left; //go to right if possible otherwise go left
        }
        while (!stack.isEmpty()) result.add(stack.pop()); // copy elements from stack to list
    }
}
