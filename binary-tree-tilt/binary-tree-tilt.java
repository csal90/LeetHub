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
    /*
        1. Problem Analysis
            - Define the term - Tilt
            - abs(sum of left subtree node values - sum of right tree node values)
            - Problem Decomposition (slices our left and right problem)
        2. Case Analysis
            - No left child => 0 (left subproblem)
            - No right child => 0 (right subproblem)
            - No nodes      =>  0 
        3. Solution Analysis
            - What if the unit of work to be done in each recursive call?
              sum of the all the tilted abs difference
              get the difference
              return the abs value
            - What traversal strat to use?
                - Postorder
            - Should I do the work in before / after recursive call?
            
        4. Time and Space analysis
    */
    int sum = 0;
    public int findTilt(TreeNode root) {
        findTiltHelper(root);
        return sum;
    }
    
    public int findTiltHelper(TreeNode root) {
        if (root == null) return 0;
        int leftSum = findTiltHelper(root.left);
        int rightSum = findTiltHelper(root.right);
        sum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
