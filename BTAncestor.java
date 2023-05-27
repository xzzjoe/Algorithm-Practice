/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (left && right) return root;
        else if (left) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
    
    public boolean dfs (TreeNode root, TreeNode p, TreeNode q){
        if (root == null)return false;
        if (root == q || root == p) return true;
        return dfs(root.left, p, q)|| dfs(root.right, p, q);
    }
}