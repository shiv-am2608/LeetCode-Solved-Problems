class Solution {
    public int calculate(String s) {
        Stack<Integer>st=new Stack<Integer>();
        int num=0,sign=1,res=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
                num=(num*10)+(int)(ch-'0');
            else if(ch=='+')
            {
                res+=sign*num;
                num=0;
                sign=1;
            }
            else if(ch=='-')
            {
                res+=sign*num;
                num=0;
                sign=-1;
            }
            else if(ch=='(')
            {
                st.push(res);
                st.push(sign);
                sign=1;
                res=0;
            }
            else if(ch==')')
            {
                res+=sign*num;
                num=0;
                res*=st.pop();
                res+=st.pop();
            }
        }
        if(num!=0)
            res+=num*sign;
        return res;
    }
}