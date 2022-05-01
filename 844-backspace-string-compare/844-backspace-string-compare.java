class Solution {
    public String generateString(String str)
    {
        Stack<Character>st=new Stack<Character>();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='#')
                st.push(str.charAt(i));
            else if(!st.isEmpty())
                st.pop();
        }
        String ans="";
        while(!st.isEmpty())
            ans=st.pop()+ans;
        return ans;
    }
    public boolean backspaceCompare(String s, String t) {
        s=generateString(s);
        t=generateString(t);
        return s.equals(t);
    }
}