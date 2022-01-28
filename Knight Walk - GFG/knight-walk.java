// { Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        Queue<int[]>q=new LinkedList<int[]>();
        boolean visited[][]=new boolean[N][N];
        int kp_x=KnightPos[0]-1;
        int kp_y=KnightPos[1]-1;
        q.offer(new int[]{kp_x,kp_y});
        visited[kp_x][kp_y]=true;
        int tp_x=TargetPos[0]-1;
        int tp_y=TargetPos[1]-1;
        int dir[][]={{-2,1},{-2,-1},{2,1},{2,-1},{1,-2},{1,2},{-1,-2},{-1,2}};
        int steps=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            
            while(size-- >0)
            {
                int curr[]=q.poll();
                int curr_x=curr[0];
                int curr_y=curr[1];
                if(curr_x==tp_x && curr_y==tp_y)
                    return steps;
                for(int i[]:dir)
                {
                    int x=curr_x+i[0];
                    int y=curr_y+i[1];
                    if(x<0||y<0 ||x>=visited.length||y>=visited[0].length||visited[x][y])
                        continue;
                    visited[x][y]=true;
                    q.offer(new int[]{x,y});
                }
            }
            steps++;
        }
        return -1;
    }
}