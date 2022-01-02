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
    public List<TreeNode> countTrees(int n)
    {
        List<TreeNode>res=new ArrayList<TreeNode>();
        if(n==1)
        {
            res.add(new TreeNode(0));
            return res;
        }
        for(int i=1;i<n;i+=2)
        {
            List<TreeNode>left=countTrees(i);
            List<TreeNode>right=countTrees(n-i-1); 
            for(TreeNode j:left)
            {
                for(TreeNode k:right)
                {
                    TreeNode curr=new TreeNode(0);
                    curr.left=j;
                    curr.right=k;
                    res.add(curr);
                }
            }
        }
        return res;
    }
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode>ans=new ArrayList<TreeNode>();
        if(n%2==0)
            return ans;
        return countTrees(n);
    }
}