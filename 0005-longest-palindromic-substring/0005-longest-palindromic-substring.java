class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++)
        {
            int pal1 = pallindromeLength(s,i,i);
            int pal2 = pallindromeLength(s,i,i+1);
            int max = pal1 > pal2 ? pal1 : pal2;
            if(max > end - start)
            {
                start = i-((max-1)/2);
                end=i+(max/2);
            }
        }
        return s.substring(start,end+1);
    }
    public int pallindromeLength(String s, int x, int y){
        while(x>=0 && y<s.length()){
            if(s.charAt(x) != s.charAt(y))
                break;
            x--;
            y++;
        }
        return (y-x-1);
    }
}