class Solution {
    public int fib(int n) {
        if(n<=1)
            return n;
        int x=0,y=1;
        for(int i=2;i<=n;i++)
        {
            int z=x;
            x=y;
            y=y+z;
        }
        return y;
    }
}