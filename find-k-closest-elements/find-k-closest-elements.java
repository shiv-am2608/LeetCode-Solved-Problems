class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0,high=arr.length-1;
        while(high-low>=k)
        {
            if(Math.abs(arr[high]-x)>=Math.abs(arr[low]-x))
                high--;
            else
                low++;
        }
        List<Integer>res=new ArrayList<Integer>();
        for(int i=low;i<=high;i++)
            res.add(arr[i]);
        return res;
    }
}