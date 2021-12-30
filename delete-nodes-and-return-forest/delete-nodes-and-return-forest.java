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
    public boolean found_and_deleted(TreeNode root,int x,List<TreeNode>res,TreeNode par)
    {
        if(root==null)
            return false;
        if(root.val==x)
        {
            if(root.left!=null)
                res.add(root.left);
            if(root.right!=null)
                res.add(root.right);
            root.left=null;
            root.right=null;
            if(par!=null)
            {
                if(par.left==root)
                    par.left=null;
                else
                    par.right=null;
            }
            else
                res.remove(root);
            return true;
        }
        return found_and_deleted(root.left,x,res,root) || found_and_deleted(root.right,x,res,root);
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode>res= new ArrayList<TreeNode>();
        res.add(root);
        for(int i:to_delete)
        {
            for(TreeNode x:res)
                if(found_and_deleted(x,i,res,null))
                    break;
        }
        return res;
    }
}