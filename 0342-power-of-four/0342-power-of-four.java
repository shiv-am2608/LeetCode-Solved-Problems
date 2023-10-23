class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1)
            return true;
        if(n<=0)
            return false;
        return Math.log(n)/Math.log(4) == (int)(Math.log(n)/Math.log(4));
    }
}