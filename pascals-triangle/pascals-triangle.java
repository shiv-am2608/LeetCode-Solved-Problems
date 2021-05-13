class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        for(int i=1;i<=numRows;i++)
        {
            int arr[]=new int[i];
            arr[0]=1;
            arr[arr.length-1]=1;
            for(int j=1;j<arr.length-1;j++)
            {
                int resSize=res.size()-1;
                int sum=res.get(resSize).get(j-1)+res.get(resSize).get(j);
                arr[j]=sum;
            }
            List<Integer>arr2=new ArrayList<Integer>();
            for(int t=0;t<arr.length;t++)
                arr2.add(arr[t]);
            res.add(arr2);
        }
        return res;
    }
}