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
    public void traverse(TreeNode root,TreeNode par,HashMap<TreeNode,TreeNode>hmap)
    {
        if(root==null)
            return;
        hmap.put(root,par);
        traverse(root.left,root,hmap);
        traverse(root.right,root,hmap);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y)
            return false;
        HashMap<TreeNode,TreeNode>hmap=new HashMap<TreeNode,TreeNode>();
        traverse(root,null,hmap);
        
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            TreeNode par1=null,par2=null;
            while(size-- > 0)
            {
                TreeNode curr=q.poll();
                if(curr.val==x)
                    par1=hmap.get(curr);
                if(curr.val==y)
                    par2=hmap.get(curr);
                if(par1!=null && par2!=null)
                {
                    if(par1!=par2)
                        return true;
                    return false;
                }
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
        }
        return false;
    }
}