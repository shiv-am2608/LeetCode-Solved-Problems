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
    public TreeNode binarySearch(int nums[],int low,int high)
    {
        if(high<low)
            return null;
        if(low==high)
            return new TreeNode(nums[low]);
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(nums[mid]);
        TreeNode left=binarySearch(nums,low,mid-1);
        TreeNode right=binarySearch(nums,mid+1,high);
        root.left=left;
        root.right=right;
        return root;
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
}