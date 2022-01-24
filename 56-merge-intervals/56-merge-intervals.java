class Pair
{
    int x,y;
    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}class Solution {
    public int[][] merge(int[][] intervals) {
        Pair arr[]=new Pair[intervals.length];
        for(int i=0;i<intervals.length;i++)
            arr[i]=new Pair(intervals[i][0],intervals[i][1]);
        Arrays.sort(arr,(t1,t2)->t1.x-t2.x);
        List<Pair>res=new ArrayList<Pair>();
        res.add(arr[0]);
        for(int i=1;i<arr.length;i++)
        {
            int n=res.size()-1;
            if(arr[i].x>res.get(n).y)
                res.add(new Pair(arr[i].x,arr[i].y));
            else if(arr[i].y>res.get(n).y)
                res.get(n).y=arr[i].y;
        }
        int ans[][]=new int[res.size()][2];
        for(int i=0;i<ans.length;i++)
        {
            ans[i][0]=res.get(i).x;
            ans[i][1]=res.get(i).y;
        }
        return ans;
    }
}