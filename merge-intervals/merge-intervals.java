class Pair
{
    int x,y;
    Pair(int a,int b)
    {
        x=a;
        y=b;
    }
}
class Compare {
  
    static void compare(Pair arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return p1.x - p2.x;
            }
        });
  
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<Pair>arr=new ArrayList<Pair>();
        Compare obj=new Compare();//to sort the array
        Pair arr2[]=new Pair[intervals.length];
        for(int i=0;i<intervals.length;i++)
            arr2[i]=new Pair(intervals[i][0],intervals[i][1]);
        obj.compare(arr2,arr2.length);
        arr.add(arr2[0]);
        for(int i=1;i<intervals.length;i++)
        {
            int n=arr.size();
            if(arr2[i].x<=arr.get(n-1).y)
            {
                if(arr2[i].y>arr.get(n-1).y) //[[1,4],[2,3]] handle testcase where proper                                                   subset of previous one
                    arr.get(n-1).y=arr2[i].y;
            }
            else
                arr.add(arr2[i]);
        }
        int ans[][]=new int[arr.size()][2];
        for(int i=0;i<arr.size();i++)
        {
            ans[i][0]=arr.get(i).x;
            ans[i][1]=arr.get(i).y;
        }
        return ans;
    }
}