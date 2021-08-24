class Solution {
    public boolean reachable(int arr[],int start,boolean visited[])
    {
        if(start<0 || start>=arr.length || visited[start])
            return false;
        visited[start]=true;
        if(arr[start]==0)
            return true;
        if(reachable(arr,start+arr[start],visited))
            return true;
        if(reachable(arr,start-arr[start],visited))
            return true;
        return false;
    }
    public boolean canReach(int[] arr, int start) {
        int possible[]=new int[arr.length];
        possible[start]=1;
        boolean visited[]=new boolean[arr.length];
        return reachable(arr,start,visited);
    }
}