class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<Integer>();
        for(String i:tokens)
        {
            if(i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/"))
            {
                char symbol=i.charAt(0);
                int x=st.pop();
                int y=st.pop();
                if(symbol=='+')
                    st.push(y+x);
                else if(symbol=='-')
                    st.push(y-x);
                else if(symbol=='/')
                    st.push(y/x);
                else if(symbol=='*')
                    st.push(y*x);
            }
            else
                st.push(Integer.parseInt(i));
        }
        return st.pop();
    }
}