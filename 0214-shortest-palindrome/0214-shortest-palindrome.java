class Solution {
    public boolean checkForPallindrome(String str){
        int i=0, j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!= str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public String reverseString(String str){
        String reverse = "";
        for(int i=str.length()-1;i>=0;i--)
            reverse+=str.charAt(i);
        return reverse;
    }
    public String shortestPalindrome(String s) {
        for(int i = s.length(); i>0;i--){
            String substring = s.substring(0,i);
            if(checkForPallindrome(substring)){
                String remaining = s.substring(i,s.length());
                String revRemaining = reverseString(remaining);
                return revRemaining + s;
            }
        }
        return reverseString(s.substring(0,s.length())) + s;
    }
}