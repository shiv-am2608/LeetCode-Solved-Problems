class Solution {
    public boolean checkBipartition(ArrayList<ArrayList<Integer>>graph,int curr,int colors[])
    {
        if(colors[curr]==-1)
            colors[curr]=1;
        for(int i:graph.get(curr))
        {
            if(colors[i]==-1)
            {
                colors[i]=1-colors[curr];
                if(!checkBipartition(graph,i,colors))
                    return false;
            }
            else if(colors[i]==colors[curr])
                return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>>graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<Integer>());
        for(int i[]:dislikes)
        {
            graph.get(i[0]-1).add(i[1]-1);
            graph.get(i[1]-1).add(i[0]-1);
        }
        int colors[]=new int[n];
        Arrays.fill(colors,-1);
        for(int i=0;i<n;i++)
            if(colors[i]==-1)
                if(!checkBipartition(graph,i,colors))
                    return false;
        return true;
    }
}