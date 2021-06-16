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

    public TreeNode build(int preStart,int inStart,int inEnd,int pre[],int in[])
    {
        if(preStart>=pre.length || inStart>inEnd)
            return null;
        TreeNode root=new TreeNode(pre[preStart]);
        int idex=0;
        for(int i=inStart;i<=inEnd;i++)
            if(in[i]==pre[preStart])
            {
                idex=i;
                break;
            }
        root.left=build(preStart+1,inStart,idex-1,pre,in);
        root.right=build(preStart+idex-inStart+1,idex+1,inEnd,pre,in);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0,0,inorder.length-1,preorder,inorder);
    }
}