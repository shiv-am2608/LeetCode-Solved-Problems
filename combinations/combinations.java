class Solution {
    public void combinations(List<List<Integer>>res,int n,int k,List<Integer>curr,int start)
    {
        if(k==0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=n;i++)
        {
            curr.add(i);
            combinations(res,n,k-1,curr,i+1);
            curr.remove(curr.size()-1);
        }
        
    }
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        List<Integer>curr=new ArrayList<Integer>();
        combinations(res,n,k,curr,1);
        return res;
    }
}