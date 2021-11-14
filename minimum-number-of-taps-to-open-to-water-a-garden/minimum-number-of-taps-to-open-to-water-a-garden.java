class Solution {
    public int minTaps(int n, int[] ranges) {
        
        //furthest distance from a point towards right
        int dist[]=new int[n+1];
        //boolean flag=false;//to handle TCs in which no taps can reach last plot
        for(int i=0;i<=n;i++)
        {
            if(ranges[i]==0)//if range is 0 we ignore it
                continue;      //*IMPORTANT* updates to i and may give ambiguity
            int left=Math.max(0,i-ranges[i]);
            int right=Math.min(n,i+ranges[i]);
            // if(right==n)
            //     flag=true;
            dist[left]=Math.max(dist[left],right);
        }
        // if(!flag)
        //     return -1;
        int far=dist[0];//stores the farthest reachable distance with a tap
        int tap=1;//stores the tap count
        if(far==n)
            return tap;
        int next_tap=0;//stores the index of next tap
        
        
        for(int i=0;i<=n;i++)
        {
            if(i>far)//if we reach more than far it is unreacable
                return -1;
            next_tap=Math.max(next_tap,dist[i]);//updating next_tap index
            if(next_tap==n)//if next tap is required at n it means we have watered all
                return tap+1;
            
            //if we reach the max possible distance then we consider the next tap
            if(far==i)
            {
                far=next_tap;
                tap++;
            }
        }
        return tap;
    }
}