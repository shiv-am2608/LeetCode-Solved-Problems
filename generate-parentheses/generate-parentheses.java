class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<String>();
        permute(res,"",n,n);
        return res;
    }
    public void permute(List<String>res,String curr,int open,int close)
    {
        if(open==0 && close==0)
        {
            res.add(curr);
            return;
        }
        if(open>0)
            permute(res,curr+"(",open-1,close);
        if(close>open)
            permute(res,curr+")",open,close-1);
    }
}