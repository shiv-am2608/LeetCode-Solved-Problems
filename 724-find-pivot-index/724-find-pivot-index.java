class Solution {
    public int pivotIndex(int[] A) {
        long presum[]=new long[A.length];
        presum[0]=A[0];
        for(int i=1;i<A.length;i++)
            presum[i]=presum[i-1]+A[i];
        for(int i=0;i<A.length;i++)
        {
            long left=i==0?0:presum[i-1];
            long right=presum[A.length-1]-presum[i];
            if(left==right)
                return i;
        }
        return -1;
    }
}