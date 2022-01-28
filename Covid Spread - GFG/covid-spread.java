// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     public int helpaterp(int[][] hospital) {
        // code here
        Queue<int[]>q=new LinkedList<int[]>();
        for(int i=0;i<hospital.length;i++)
        {
            for(int j=0;j<hospital[0].length;j++)
            {
                if(hospital[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                    hospital[i][j]=0;
                }
            }
        }
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        int timer=-1;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-->0)
            {
                int curr[]=q.poll();
                for(int i[]:dir)
                {
                    int nextx=i[0]+curr[0];
                    int nexty=i[1]+curr[1];
                    if(nextx<0 || nexty<0 || nextx>=hospital.length || nexty>=hospital[0].length || hospital[nextx][nexty]==0)
                        continue;
                    q.offer(new int[]{nextx,nexty});
                    hospital[nextx][nexty]=0;
                }
            }
            timer++;
        }
        for(int i=0;i<hospital.length;i++)
        {
            for(int j=0;j<hospital[0].length;j++)
            {
                if(hospital[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return timer;
    }
}
