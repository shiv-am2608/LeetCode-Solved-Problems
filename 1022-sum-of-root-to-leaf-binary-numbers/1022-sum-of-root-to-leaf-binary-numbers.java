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
    public int findSum(TreeNode root,int sum)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
        {
            return (sum*2)+root.val;
        }
        int data=(sum*2)+root.val;
        return findSum(root.left,data)+findSum(root.right,data);
    }
    public int sumRootToLeaf(TreeNode root) {
        return findSum(root,0);
    }
}