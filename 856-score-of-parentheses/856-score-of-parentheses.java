class Solution {
    public int scoreOfParentheses(String s) {
        int len = s.length(), parentheses = 0, res = 0;
        for (int i = 1; i < len; i++)
        if (s.charAt(i) == '(') 
            parentheses++;
        else if (s.charAt(i-1) == '(') 
            res += 1 << parentheses--;
        else 
            parentheses--;
        return res;
    }
}