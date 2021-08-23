class Solution {
    public List<String> commonChars(String[] words) {
        int ch[]=new int[26];
        String first=words[0];
        for(int i=0;i<first.length();i++)
            ch[first.charAt(i)-'a']++;
        for(int i=1;i<words.length;i++)
        {
            String curr=words[i];
            int freq[]=new int[26];
            for(int j=0;j<curr.length();j++)
                freq[curr.charAt(j)-'a']++;
            for(int j=0;j<26;j++)
                if(ch[j]!=freq[j])
                    ch[j]=Math.min(ch[j],freq[j]);
                    
        }
        List<String>res=new ArrayList<String>();
        for(int i=0;i<26;i++)
            while(ch[i]--!=0)
                res.add(Character.toString('a'+(char)i));
        return res;
    }
}