class Solution {
    public int jump(int[] arr) {
        if(arr.length==1)
            return 0;
        if(arr[0]==0)
            return -1;
        int jumps=1;
        int steps=arr[0];
        int maxR=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(i==arr.length-1)
                return jumps;
            steps--;
            maxR=Math.max(maxR,i+arr[i]);
            if(steps==0)
            {
                if(i>=maxR)
                    return -1;
                jumps++;
                steps=maxR-i;
            }
        }
        return jumps;
    }
}