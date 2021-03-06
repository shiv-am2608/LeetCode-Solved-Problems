class Solution {
    public int calculate(String s) {
        s=s+'+';
        Stack<Integer>st=new Stack<Integer>();
        int curr=0;
        char op='+';
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==' ')
                continue;
            if(Character.isDigit(ch))
                curr=(curr*10)+(ch-'0');
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                if(op=='+')
                    st.push(curr);
                else if(op=='-')
                    st.push(-curr);
                else if(op=='*')
                    st.push(st.pop()*curr);
                else if(op=='/')
                    st.push(st.pop()/curr);
                curr=0;
                op=ch;
            }
        }
        int ans=0;
        while(!st.isEmpty())
            ans+=st.pop();
        return ans;
    }
}