// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            int[] start = new int[N];
            int[] end = new int[N];
            
            for(int i=0; i<N; i++)
            {
                start[i] = Integer.parseInt(S1[i]);
                end[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxEvents(start,end,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Pair{
    int x,y;
    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution {
    static int maxEvents(int[] start, int[] end, int N) {
        // code here
        Pair p[]=new Pair[N];
        for(int i=0;i<N;i++)
            p[i]=new Pair(start[i],end[i]);
        Arrays.sort(p,(t1,t2)->(t1.x-t2.x));
        int i=0;
        int day=0;
        int count=0;
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
        while(i<N || !pq.isEmpty())
        {
            if(pq.isEmpty())
                day=p[i].x;
            while(i<N && p[i].x==day)
            {
                pq.offer(p[i].y);
                i++;
            }
            count++;
            day++;
            pq.poll();
            while(!pq.isEmpty() && pq.peek()<day)
                pq.poll();
        }
        return count;
    }
};