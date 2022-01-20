class Solution {
    public boolean isValid(int piles[],int h,int mid)
    {
        int count=0;
        for(int i=0;i<piles.length;i++)
        {
            count+=Math.ceil(piles[i]/(double)mid);
            if(count>h)
                return false;
        }
        return true;
    }
    public int binarySearch(int piles[],int h,int low,int high)
    {
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=high-(high-low)/2;
            if(isValid(piles,h,mid))
            {
                high=mid-1;
                ans=Math.min(ans,mid);
            }
            else
                low=mid+1;
        }
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int i:piles)
            max=Math.max(max,i);
        return binarySearch(piles,h,1,max);
    }
}