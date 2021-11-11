class Solution {
    public int uniqueLetterString(String s) {
        int prev[]=new int[26];
        int prevToprev[]=new int[26];
        int sum=0,curr=0;
        Arrays.fill(prev,-1);
        Arrays.fill(prevToprev,-1);
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'A';
            curr = curr + (i-prev[index]-1) - (prev[index]-prevToprev[index]) + 1;
            prevToprev[index]=prev[index];
            prev[index]=i;
            sum+=curr;
        }
        return sum;
    }
}