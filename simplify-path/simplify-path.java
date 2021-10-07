class Solution {
    public String simplifyPath(String path) {
        String str[]=path.split("/");
        Stack<String>st=new Stack<String>();
        for(String i:str)
        {
            if(i.equals("") || i.equals("."))
                continue;
            if(i.equals(".."))
            {
                
                if(!st.isEmpty())
                    st.pop();
            }
            else
                st.push(i);
        }
        String ans="";
        while(!st.isEmpty())
            ans="/" + st.pop()+ans;
        return ans.length()==0?"/":ans;
    }
}