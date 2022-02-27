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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        Queue<Long>val=new LinkedList<Long>();
        q.offer(root);
        val.offer(0L);
        int ans=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            long left=0,right=0;
            for(int i=0;i<size;i++)
            {
                if(i==0)
                    left=val.peek();
                if(i==size-1)
                    right=val.peek();
                TreeNode curr=q.poll();
                long currVal=val.poll();
                if(curr.left!=null)
                {
                    q.offer(curr.left);
                    val.offer(2*currVal+1);
                }
                if(curr.right!=null)
                {
                    q.offer(curr.right);
                    val.offer(currVal*2 +2);
                }
            }
            ans=(int)Math.max(ans,right-left+1);
        }
        return ans;
    }
}