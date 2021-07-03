class Solution {
    public boolean judgeSquareSum(int c) {
        //max possible range is 0 to Math.sqrt(c)
        int l=0;
        int r=(int)Math.sqrt(c);
        
        //applied two pointer approach
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