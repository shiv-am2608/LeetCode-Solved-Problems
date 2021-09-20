class Solution {
    public int minTaps(int n, int[] ranges) {
        int dist[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            if(ranges[i]==0)
                continue;
            int left=Math.max(0,i-ranges[i]);
            int right=Math.min(n,i+ranges[i]);
            dist[left]=Math.max(dist[left],right);
        }
        int far=dist[0];
        int tap=1;
        if(far==n)
            return tap;
        int next_tap=0;
        for(int i=0;i<n;i++)
        {
            if(i>far)
                return -1;
            next_tap=Math.max(next_tap,dist[i]);
            if(next_tap==n)
                return tap+1;
            if(far==i)
            {
                far=next_tap;
                tap++;
            }
        }
        return tap;
    }
}