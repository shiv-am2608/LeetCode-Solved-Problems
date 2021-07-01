class Solution {
    public boolean judgeSquareSum(int c) {
        int l=0;
        int r=(int)Math.sqrt(c);
        while(l<=r)
        {
            int num=(l*l)+(r*r);
            if(num==c)
                return true;
            else if(num<c)
                l++;
            else
                r--;
        }
        return false;
    }
}