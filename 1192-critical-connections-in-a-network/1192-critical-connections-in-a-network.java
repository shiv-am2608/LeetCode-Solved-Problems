class Solution {
    int time=0;
    public void dfs(int u,List<List<Integer>>adj,List<List<Integer>>ans,int low[],int disc[],int parent[])
    {
        low[u]=time;
        disc[u]=time;
        time++;
        for(int i:adj.get(u))
        {
            if(disc[i]==-1)
            {
                parent[i]=u;
                dfs(i,adj,ans,low,disc,parent);
                low[u]=Math.min(low[u],low[i]);
                if(low[i]>disc[u])
                {
                    ArrayList<Integer>temp=new ArrayList<Integer>();
                    temp.add(u);
                    temp.add(i);
                    ans.add(temp);
                }
            }
            else if(i!=parent[u])
            {
                low[u]=Math.min(low[u],disc[i]);
            }
        }
    }
    public void tarjans(int n,List<List<Integer>>adj,List<List<Integer>>ans)
    {
        int low[]=new int[n];
        int disc[]=new int[n];
        int parent[]=new int[n];
        Arrays.fill(low,-1);
        Arrays.fill(disc,-1);
        Arrays.fill(parent,-1);
        dfs(0,adj,ans,low,disc,parent);
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        List<List<Integer>>adj=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(List<Integer>x:connections)
        {
            adj.get(x.get(0)).add(x.get(1));
            adj.get(x.get(1)).add(x.get(0));
        }
        tarjans(n,adj,ans);
        return ans;
    }
}