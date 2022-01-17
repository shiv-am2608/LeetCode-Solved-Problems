class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum=0;
        for(int i:batteries)
            sum+=i;
        int noBat=batteries.length-1;
        int k=0;
        while(batteries[noBat-k]>sum/(n-k))
        {
            sum-=batteries[noBat-k];
            k++;
        }
        return sum/(n-k);
        
    }
}