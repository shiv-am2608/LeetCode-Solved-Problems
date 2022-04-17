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
    public boolean findPath(TreeNode root, TreeNode target,List<TreeNode>path)
    {
        if(root==null)
            return false;
        path.add(root);
        if(root==target)
            return true;
        if(findPath(root.left,target,path))
            return true;
        if(findPath(root.right,target,path))
            return true;
        path.remove(root);
        return false;
    }
    public void findNodes(int dist,TreeNode root,List<TreeNode>path,boolean isFirst,List<Integer>ans)
    {
        if(root==null)
            return;
        if(path.contains(root) && !isFirst)
            return;
        if(dist==0)
        {
            ans.add(root.val);
            return;
        }
        findNodes(dist-1,root.left,path,false,ans);
        findNodes(dist-1,root.right,path,false,ans);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> path=new ArrayList<TreeNode>();
        findPath(root,target,path);
        
        List<Integer>ans=new ArrayList<Integer>();
        for(int i=0;i<path.size();i++)
        {
            int dist=k-(path.size()-i-1);
            if(dist<0)
                continue;
            findNodes(dist,path.get(i),path,true,ans);
        }
        return ans;
    }
}