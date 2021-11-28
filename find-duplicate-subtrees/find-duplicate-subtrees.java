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
    public String inOrder(TreeNode root,List<TreeNode>res,HashMap<String,Integer>hmap)
    {
        if(root==null)
            return "";
        String str="(";
        str+=inOrder(root.left,res,hmap);
        str+=Integer.toString(root.val);
        str+=inOrder(root.right,res,hmap);
        str+=")";
        if(hmap.containsKey(str))
        {
            if(hmap.get(str)==1)
                res.add(root);
            hmap.put(str,hmap.get(str)+1);
        }
        else
            hmap.put(str,1);
        return str;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>res=new ArrayList<TreeNode>();
        HashMap<String,Integer>hmap=new HashMap<String,Integer>();
        inOrder(root,res,hmap);
        return res;
    }
}