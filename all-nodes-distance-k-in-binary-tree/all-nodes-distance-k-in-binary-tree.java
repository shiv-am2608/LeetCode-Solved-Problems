/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode>path=new ArrayList<TreeNode>();
    List<Integer>ans=new ArrayList<Integer>();
    public boolean findPath(TreeNode root,TreeNode target)
    {
        if(root==null)
            return false;
        path.add(root);
        if(root==target)
            return true;
        if(findPath(root.left,target) || findPath(root.right,target))
            return true;
        path.remove(root);
        return false;
    }
    public void kthDistance(TreeNode root,int k,boolean first)
    {
        if(!first && (root==null || path.contains(root)))
            return;
        if(k==0)
        {
            ans.add(root.val);
            return;
        }
        kthDistance(root.left,k-1,false);
        kthDistance(root.right,k-1,false);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findPath(root,target);
        kthDistance(target,k,true);
        for(int i=0;i<path.size()-1;i++)
        {
            int dist=k+i-path.size()+1;
            kthDistance(path.get(i),dist,true);
        }
        return ans;
    }
}