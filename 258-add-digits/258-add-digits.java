class Solution {
    public int addDigits(int num) {
        return 1 + (num-1)%9;
        // if(num==0)
        //     return 0;
        // return num%9==0? 9 : num%9;
    }
}