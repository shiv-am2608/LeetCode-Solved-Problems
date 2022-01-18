class Solution {
    boolean check(char a,char b)
    {
        if((a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']'))
            return true;
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' ||s.charAt(i)=='{' ||s.charAt(i)=='[')
                st.push(s.charAt(i));
            else if(st.isEmpty())
                return false;
            else if(check(st.peek(),s.charAt(i)))
                st.pop();
            else
                return false;
        }
        return st.isEmpty();
    }
}