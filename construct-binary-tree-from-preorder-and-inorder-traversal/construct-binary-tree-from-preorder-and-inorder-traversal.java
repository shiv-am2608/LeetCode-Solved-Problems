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
    int pre=0;
    public TreeNode build(int preorder[],int inorder[],int is,int ie)
    {
        if(is>ie || pre==preorder.length)
            return null;
        TreeNode root=new TreeNode(preorder[pre++]);
        if(is==ie)
            return root;
        int index=0;
        for(int i=is;i<=ie;i++)
            if(inorder[i]==preorder[pre-1])
            {
                index=i;
                break;
            }
        root.left=build(preorder,inorder,is,index-1);
        root.right=build(preorder,inorder,index+1,ie);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length);
    }
}