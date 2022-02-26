class Pair{
    int val,mask;
    Pair(int val,int mask){
        this.val=val;
        this.mask=mask;
    }
}
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        int target=(1<<n)-1;
        
        Queue<Pair>q=new LinkedList<Pair>();
        for(int i=0;i<n;i++)
            q.offer(new Pair(i,1<<i));
        
        boolean visited[][]=new boolean[n][target];
        
        int steps=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-->0)
            {
                Pair curr=q.poll();
                if(curr.mask==target)
                    return steps;
                if(visited[curr.val][curr.mask])
                    continue;
                visited[curr.val][curr.mask]=true;
                for(int x:graph[curr.val])
                    q.offer(new Pair(x, curr.mask | (1<<x) ));
            }
            steps++;
        }
        return -1;
    }
}