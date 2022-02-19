class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer>tset=new TreeSet<Integer>();
        for(int i:nums)
        {
            if(i%2==0)
                tset.add(i);
            else
                tset.add(i*2);
        }
        int minDiff=tset.last()-tset.first();
        while(tset.last()%2==0)
        {
            int m=tset.last();
            tset.remove(m);
            tset.add(m/2);
            minDiff=Math.min(minDiff,tset.last()-tset.first());
        }
        return minDiff;
    }
}