package GFG;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

class Pair<K, V>{
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class Binary_Tree_Preorder_Inorder_Postorder_Traversals_in_one_Traversal {
    public static void main(String[] args) {
        // Create nodes manually
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Traversals(root);
    }
    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // ********************* Main Answer ************************
    static void Traversals(TreeNode root){
        Stack<Pair<TreeNode,Integer>> st=new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        // Start with the root node
        // and state 1 (preorder)
        st.push(new Pair<>(root, 1));

        while (!st.empty()) {
            Pair<TreeNode, Integer> it = st.pop();

            // this is part of pre
            if (it.getValue() == 1) {
                // Store the node's data
                // in the preorder traversal
                pre.add(it.getKey().val);
                // Move to state 2
                // (inorder) for this node
                it.setValue(2);
                // Push the updated state
                // back onto the stack
                st.push(it);

                // Push left child onto
                // the stack for processing
                if (it.getKey().left != null) {
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            }

            // this is a part of in
            else if (it.getValue() == 2) {
                // Store the node's data
                // in the inorder traversal
                in.add(it.getKey().val);
                // Move to state 3
                // (postorder) for this node
                it.setValue(3);
                // Push the updated state
                // back onto the stack
                st.push(it);

                // Push right child onto
                // the stack for processing
                if (it.getKey().right != null) {
                    st.push(new Pair<>(it.getKey().right, 1));
                }
            }

            // this is part of post
            else {
                // Store the node's data
                // in the postorder traversal
                post.add(it.getKey().val);
            }
        }

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);
    }
}
