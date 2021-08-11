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
    public boolean check(TreeNode root,int sum,int target)
    {
         if(root==null)
           return false;
        sum+=root.val;
        if(root.left==null && root.right==null && sum==target)
            return true;
        return check(root.left,sum,target) || check(root.right,sum,target);
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        return check(root,0,targetSum);
        
    }
}