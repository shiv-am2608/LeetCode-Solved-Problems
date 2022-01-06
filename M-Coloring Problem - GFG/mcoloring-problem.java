// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int V = scan.nextInt();
            int C = scan.nextInt();
            int E = scan.nextInt();

            List<Integer>[] G = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                G[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                G[u].add(v);
                G[v].add(u);
            }
            int[] color = new int[V];

            System.out.println(new solve().graphColoring(G, color, 0, C) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve 
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean isSafe(int curr,List<Integer>g[],int color[],int c)
    {
        for(int i:g[curr])
        {
            if(color[i]==c)
                return false;
        }
        return true;
    }
    public static boolean solve(int curr,List<Integer>g[],int color[],int n,int m)
    {
        if(curr==n)
            return true;
        for(int i=1;i<=m;i++)
        {
            if(isSafe(curr,g,color,i))
            {
                color[curr]=i;
                if(solve(curr+1,g,color,n,m))
                    return true;
                color[curr]=0;
            }
        }
        return false;
    }
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
        // Your code here
        return solve(0,G,color,G.length,C);
    }
}