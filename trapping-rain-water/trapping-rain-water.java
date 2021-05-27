class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<=2)
            return 0;
        int leftmax[]=new int[n];
        int rightmax[]=new int[n];
        leftmax[0]=height[0];
        rightmax[n-1]=height[n-1];
        for(int i=1;i<n;i++)
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        for(int i=n-2;i>=0;i--)
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        int water=0;
        for(int i=1;i<n-1;i++)
            water+=Math.min(leftmax[i],rightmax[i])-height[i];
        return water;
        
    }
}