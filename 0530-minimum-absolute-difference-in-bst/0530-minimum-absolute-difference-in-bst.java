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
    public void inorder(ArrayList<Integer>arr, TreeNode root)
    {
        if(root==null)
            return;
        inorder(arr,root.left);
        arr.add(root.val);
        inorder(arr,root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer>arr=new ArrayList<Integer>();
        inorder(arr,root);
        int ans= Integer.MAX_VALUE;
        for(int i=1;i<arr.size();i++)
            ans=Math.min(Math.abs(arr.get(i-1)-arr.get(i)),ans);
        return ans;
    }
}