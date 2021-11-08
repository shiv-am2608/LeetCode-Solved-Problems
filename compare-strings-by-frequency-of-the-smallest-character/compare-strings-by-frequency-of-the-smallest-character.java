class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int res[]=new int[queries.length];
        int freq[]=new int[words.length];
        for(int i=0;i<words.length;i++)
        {
            String str=words[i];
            int smallest=str.charAt(0);
            int count=1;
            for(int j=1;j<str.length();j++)
            {
                if(str.charAt(j)<smallest)
                {
                    smallest=str.charAt(j);
                    count=1;
                }
                else if(smallest==str.charAt(j))
                    count++;
            }
            freq[i]=count;
        }
        for(int i=0;i<queries.length;i++)
        {
            int ans=0;
            String str=queries[i];
            int smallest=str.charAt(0);
            int count=1;
            for(int j=1;j<str.length();j++)
            {
                if(str.charAt(j)<smallest)
                {
                    smallest=str.charAt(j);
                    count=1;
                }
                else if(smallest==str.charAt(j))
                    count++;
            }
            for(int j:freq)
                if(j>count)
                    ans++;
            res[i]=ans;
        }
        return res;
    }
}