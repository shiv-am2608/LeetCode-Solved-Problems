class Solution {
    public boolean isPossible(String s){
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        if(i>=j)
            return true;
        String str=s.substring(i,j+1);
        return isPossible(str.substring(1)) || isPossible(str.substring(0,str.length()-1));
    }
}