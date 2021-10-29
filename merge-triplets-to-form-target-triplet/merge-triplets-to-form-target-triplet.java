class Solution {
    public boolean check(int x[],int y[])
    {
        if(x[0]>y[0] || x[1]>y[1] || x[2]>y[2])
            return false;
        return true;
    }
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int ans[]={0,0,0};
        for(int i[]:triplets)
        {
            if(check(i,target))
            {
                ans[0]=Math.max(ans[0],i[0]);
                ans[1]=Math.max(ans[1],i[1]);
                ans[2]=Math.max(ans[2],i[2]);
            }
        }
        return ans[0]==target[0] && ans[1]==target[1] && ans[2]==target[2];
    }
}