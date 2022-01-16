class Solution {
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        int right[]=new int[n];
        int r=-1;
        for(int i=n-1;i>=0;i--)
        {
            if(seats[i]==1)
            {
                right[i]=-1;
                r=i;
            }
            else
                right[i]=r;
        }
        
        int left[]=new int[n];
        int l=-1;
        for(int i=0;i<n;i++)
        {
            if(seats[i]==1)
            {
                left[i]=-1;
                l=i;
            }
            else
                left[i]=l;
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(seats[i]==1)
                continue;
            int le=left[i]==-1?Integer.MAX_VALUE:i-left[i];
            int ri=right[i]==-1?Integer.MAX_VALUE:right[i]-i;
            int closest=Math.min(le,ri);
            max=Math.max(max,closest);
        }
        return max;
    }
}