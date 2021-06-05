class Solution {
    public void DFS(List<List<Integer>>arr,int src,int dest,int graph[][],List<Integer>temp)
    {
       // List<Integer>temp=new ArrayList<Integer>();
        if(src==dest)
        {
            arr.add(new ArrayList<Integer>(temp));
            return;
        }
       
        for(int x:graph[src])
        {
            temp.add(x);
            DFS(arr,x,dest,graph,temp);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>>res=new ArrayList<List<Integer>>();
        List<Integer>temp=new ArrayList<Integer>();
        temp.add(0);
        DFS(res,0,graph.length-1,graph,temp);
        return res;
    }
}