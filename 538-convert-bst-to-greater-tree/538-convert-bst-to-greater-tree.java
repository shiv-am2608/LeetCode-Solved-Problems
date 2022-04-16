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
    public void converted(TreeNode root,TreeNode sum){
        if(root==null)
            return;
        converted(root.right,sum);
        sum.val+=root.val;
        root.val=sum.val;
        converted(root.left,sum);
    }
    public TreeNode convertBST(TreeNode root) {
        TreeNode sum=new TreeNode(0);
        converted(root,sum);
        return root;
    }
}