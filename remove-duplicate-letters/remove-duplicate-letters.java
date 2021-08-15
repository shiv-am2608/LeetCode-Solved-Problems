class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
        Stack<Character>st=new Stack<Character>();
        HashSet<Character>hs=new HashSet<Character>();
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']--;
            if(hs.contains(s.charAt(i)))        
                continue;
            while(!st.isEmpty() && s.charAt(i)<st.peek() && freq[st.peek()-'a']>0)
            {
                hs.remove(st.peek());
                st.pop();
            }
            st.push(s.charAt(i));
            hs.add(s.charAt(i));
        }
        String res="";
        while(!st.isEmpty())
            res=st.pop()+res;
        return res;
    }
}