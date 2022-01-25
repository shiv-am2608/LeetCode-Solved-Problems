class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>up=new ArrayList<Integer>();
        List<Integer>res=new ArrayList<Integer>();
        up.add(1);
        for(int i=1;i<=rowIndex;i++)
        {
            res.add(1);
            for(int j=1;j<up.size();j++)
                res.add(up.get(j)+up.get(j-1));
            res.add(1);
            up=new ArrayList<Integer>(res);
            res.clear();
        }
        return up;
    }
}