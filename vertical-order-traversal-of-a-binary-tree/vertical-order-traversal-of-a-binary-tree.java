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
    
    public static void vertical(TreeNode root,int param,TreeMap<Integer,List<Integer>>hmap2)
    {
        Queue<TreeNode>q=new LinkedList<TreeNode>(); //stored the TreeNode
        Queue<Integer>loc=new LinkedList<Integer>(); //stored the loc of TreeNode
        q.add(root);
        loc.add(0);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            
            //created a local hashmap to keep track of nodes and its loc per level
            TreeMap<Integer,List<Integer>>hmap=new TreeMap<Integer,List<Integer>>();
            
            //processing level wise
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                int curr_loc=loc.poll();
                if(hmap.containsKey(curr_loc))
                {
                    hmap.get(curr_loc).add(curr.val);
                    Collections.sort(hmap.get(curr_loc));
                }
                else
                {
                    List<Integer>arr=new ArrayList<Integer>();
                    arr.add(curr.val);
                    hmap.put(curr_loc,arr);
                }
                if(curr.left!=null)
                {
                    q.add(curr.left);
                    loc.add(curr_loc-1);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                    loc.add(curr_loc+1);
                }
            }
            
            //Merging Local Map with Global Map
            for(Map.Entry<Integer,List<Integer>>entry:hmap.entrySet())
            {
                if(hmap2.containsKey(entry.getKey()))
                {
                    hmap2.get(entry.getKey()).addAll(hmap.get(entry.getKey()));
                }
                else
                {
                    hmap2.put(entry.getKey(),entry.getValue());
                }
            }
            
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>arr=new ArrayList<List<Integer>>();
        TreeMap<Integer,List<Integer>>hmap=new TreeMap<Integer,List<Integer>>();
        vertical(root,0,hmap);
         for (Map.Entry<Integer,List<Integer>> entry : hmap.entrySet())
             arr.add(entry.getValue());
        return arr;
    }
}