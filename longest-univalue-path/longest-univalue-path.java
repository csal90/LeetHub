/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max;
    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        longestUnivaluePathHelper(root);
        return max;
    }
    
    public int longestUnivaluePathHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
​
        int left = longestUnivaluePathHelper(root.left);
        int right = longestUnivaluePathHelper(root.right);
        
        int leftEdge = 0;
        int rightEdge = 0;
        
        if (root.left != null && root.left.val == root.val) {
            leftEdge = left + 1;
        }
        
        if (root.right != null && root.right.val == root.val) {
            rightEdge = right + 1;
        }
        max = Math.max(max, leftEdge + rightEdge);
        return Math.max(leftEdge, rightEdge);
    }
    
}
