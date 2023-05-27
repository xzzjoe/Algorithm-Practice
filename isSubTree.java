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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isValid(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isValid(TreeNode root, TreeNode subRoot){
        if (subRoot == null) {
            if (root == null){
                return true;
            }
            else{
                return false;
            }
        }
        if (root == null) return false;
        if (root.val != subRoot.val) return false;
        return isValid(root.left, subRoot.left) && isValid(root.right, subRoot.right);
    }
}