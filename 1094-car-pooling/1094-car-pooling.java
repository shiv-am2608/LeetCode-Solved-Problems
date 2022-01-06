class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int prefix[]=new int[1001];
        int end=-1,start=1001;
        for(int i=0;i<trips.length;i++)
        {
            prefix[trips[i][1]]+=trips[i][0];
            prefix[trips[i][2]]-=trips[i][0];
            start=Math.min(start,trips[i][1]);
            end=Math.max(end,trips[i][2]);
        }
        for(int i=start+1;i<=end;i++)
        {
            prefix[i]+=prefix[i-1];
            if(prefix[i-1]>capacity)
                return false;
        }
        return true;
    }
}