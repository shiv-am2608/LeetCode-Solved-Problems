class Solution {
    int res=0;
    public void factorial(int n,boolean isPositive)
    {
            if(n==0)
                return;
            int ans=0;
            int temp=0;
            if(n>0)
            {
                ans=n;
                n--;
            }
            if(n>0)
            {
                ans*=n;
                n--;
            }
            if(n>0)
            {
                ans/=n;
                n--;
            }
            if(n>0)
            {
                temp=n;
                n--;
            }
        if(isPositive)
        {
            res+=ans;
            isPositive=false;
        }
        else
        {
            res-=ans;
            //isPositive=true;
        }
        res+=temp;
        factorial(n,isPositive);
    }
    public int clumsy(int n) {
        factorial(n,true);
        return res;
    }
}