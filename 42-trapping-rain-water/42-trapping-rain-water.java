class Solution {
    public int trap(int[] height) {
        if(height.length<=2)
            return 0;
        int leftMax=0,rightMax=0;
        int left=0,right=height.length-1;
        int area=0;
        while(left<right)
        {
            leftMax=Math.max(height[left],leftMax);
            rightMax=Math.max(height[right],rightMax);
            if(leftMax<rightMax)
            {
                area+=leftMax-height[left];
                left++;
            }
            else
            {
                area+=rightMax-height[right];
                right--;
            }
        }
         return area;
    }
}