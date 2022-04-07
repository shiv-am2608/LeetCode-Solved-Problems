class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        Stack<Character>st=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(s.charAt(i)=='(')
                st.push(ch);
            else if(st.isEmpty())
                count++;
            else
                st.pop();
        }
        return count+st.size();
    }
}