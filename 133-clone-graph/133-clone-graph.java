/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    void dfs(Node node,HashMap<Node,Node>hmap)
    {
        if(hmap.containsKey(node))
            return;
        Node mynode=new Node(node.val);
        hmap.put(node,mynode);
        for(Node x:node.neighbors)
            dfs(x,hmap);
    }
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        HashMap<Node,Node>hmap=new HashMap<Node,Node>();
        dfs(node,hmap);
        for(Map.Entry<Node,Node>mp:hmap.entrySet())
        {
           for(Node x:mp.getKey().neighbors)
               mp.getValue().neighbors.add(hmap.get(x));
        }
        return hmap.get(node);
    }
}