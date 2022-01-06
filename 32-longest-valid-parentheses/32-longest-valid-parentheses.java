class Solution {
    public int solve(String s)
    {
        int left=0,right=0;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                left++;
            else 
                right++;
            if(left==right)
                max=Math.max(max,2*right);
            else if(right>left)
            {
                left=0;
                right=0;
            }
        }
        
        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='(')
                left++;
            else 
                right++;
            if(left==right)
                max=Math.max(max,2*left);
            else if(right<left)
            {
                left=0;
                right=0;
            }
        }
        return max;
    }
    public int longestValidParentheses(String s) {
        return solve(s);
    }
}