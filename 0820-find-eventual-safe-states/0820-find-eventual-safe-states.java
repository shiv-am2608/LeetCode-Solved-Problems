class Solution {
    public boolean isSafe(int graph[][],HashSet<Integer>visited,int start,HashSet<Integer>unsafe,TreeSet<Integer>safe)
    {
        int nodes[] = graph[start];
        boolean isSafe = true;
        for(int i=0;i<nodes.length;i++)
        {
            if(visited.contains(nodes[i]) || unsafe.contains(nodes[i]))
            {
                isSafe=false;
                break;
            }
            if(safe.contains(nodes[i]))
                continue;
            visited.add(nodes[i]);
            if(!isSafe(graph,visited,nodes[i],unsafe,safe))
                isSafe = false;
            visited.remove(nodes[i]);
        }
        if(isSafe)
            safe.add(start);
        else
            unsafe.add(start);
        return isSafe;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        TreeSet<Integer>safe=new TreeSet<Integer>();
        HashSet<Integer>unsafe=new HashSet<Integer>();
        for(int i=0;i<graph.length;i++)
        {
            HashSet<Integer>hs=new HashSet<Integer>();
            if(isSafe(graph,hs,i,unsafe,safe))
                safe.add(i);
            else
                unsafe.add(i);
        }
        ArrayList<Integer>arr = new ArrayList<Integer>();
        for(int i:safe)
            arr.add(i);
        return arr;
    }
}