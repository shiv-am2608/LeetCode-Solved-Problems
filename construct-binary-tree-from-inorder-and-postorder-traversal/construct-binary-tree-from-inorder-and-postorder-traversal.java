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
    int post;
    public TreeNode build(int inorder[],int postorder[],int inStart,int inEnd)
    {
        if(post<0 || inStart>inEnd)
            return null;
        TreeNode curr=new TreeNode(postorder[post]);
        int idx=-1;
        for(int i=inStart;i<=inEnd;i++)
        {
            if(inorder[i]==postorder[post])
            {
                idx=i;
                break;
            }
        }
        post--;
        curr.right=build(inorder,postorder,idx+1,inEnd);
        curr.left=build(inorder,postorder,inStart,idx-1); 
        return curr;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post=postorder.length-1;
        return build(inorder,postorder,0,inorder.length-1);
    }
}