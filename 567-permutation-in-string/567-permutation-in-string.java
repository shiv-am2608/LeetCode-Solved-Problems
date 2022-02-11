class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int freq[]=new int[26];
        int count=0;
        for(int i=0;i<s1.length();i++)
        {
            int index=s1.charAt(i)-'a';
            if(freq[index]==0)
                count++;
            freq[index]++;
        }
        for(int i=0;i<s2.length();i++)
        {
            if(i>=s1.length())
            {
                if(freq[s2.charAt(i-s1.length())-'a']==0)
                    count++;
                freq[s2.charAt(i-s1.length())-'a']++;
            }
            freq[s2.charAt(i)-'a']--;
            if(freq[s2.charAt(i)-'a']==0)
                count--;
            if(count==0)
                return true;
        }
        return false;
    }
}