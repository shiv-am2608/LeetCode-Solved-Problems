class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<Integer>();
        int freq[]=new int[26];
        int count=0;
        for(int i=0;i<p.length();i++)
        {
            int index=p.charAt(i)-'a';
            if(freq[index]==0)
                count++;
            freq[index]++;
        }
        for(int i=0;i<s.length();i++)
        {
            int index=0;
            if(i>=p.length())
            {
                index=s.charAt(i-p.length())-'a';
                if(freq[index]==0)
                    count++;          
                freq[index]++;
            }
            index=s.charAt(i)-'a';
            freq[index]--;
            if(freq[index]==0)
                count--;
            if(count==0)
                ans.add(i-p.length()+1);
        }
        return ans;
    }
}