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
    private int longestPath = 0;
    public int longestZigZag(TreeNode root) {
        helper(root, 'l');
        helper(root, 'r'); 
        return longestPath - 1;
    }
    private int helper(TreeNode root, char direction)
    {
        if(root == null) return 0;
        int path = 1;
        int alternatePath = 1;
        
        if(direction == 'l')
        {
            path += helper(root.right, 'r');
            alternatePath += helper(root.left, 'l');
        }  
        else
        {
            path += helper(root.left, 'l');
            alternatePath += helper(root.right, 'r');
        }
        longestPath = Math.max(longestPath, path);
        longestPath = Math.max(longestPath, alternatePath); 
        return path;    
    }
}