import java.util.PriorityQueue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // recursive
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
            TreeNode left = root.left;
            TreeNode right = root.left;
            root.right = invertTree(left);
            root.left = invertTree(right);
            return root; 
    }

    // Stack
    public TreeNode invertTree(TreeNode root){
        if (root == null) return null; 
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
                TreeNode curr = stack.pop();
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                curr.left = right;
                curr.right = left;
                if (curr.left != null){
                    stack.add(curr.left);
                }
                if (curr.right != null){
                    stack.add(curr.right);
                }
            }
        return root;
        }
}
