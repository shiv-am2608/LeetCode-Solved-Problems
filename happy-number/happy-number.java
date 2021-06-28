class Solution {
    public int squaresum(int n)
    {
        int res=0;
        while(n>0)
        {
            int temp=n%10;
            res+=temp*temp;
            n=n/10;
        }
        return res;
    }
    public boolean isHappy(int n) {
        HashSet<Integer>hs=new HashSet<Integer>();
        while(n!=1)
        {
            if(hs.contains(n))
                break;
            hs.add(n);
            n=squaresum(n);
        }
        if(n==1)
            return true;
        return false;
    }
}