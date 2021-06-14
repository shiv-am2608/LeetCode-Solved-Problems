class Solution {
    public void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public int firstMissingPositive(int[] nums)
    {
        int n = nums.length;
	    for(int i=0;i<n;i++)
        {
            int number = nums[i];
            int correct_pos = number-1;
            if(correct_pos<0 || correct_pos>n-1 || nums[correct_pos]==number)
                continue;
            swap(nums, i, correct_pos);
            i--;
	    }
        for(int i=0;i<n;i++)
            if(nums[i]!=i+1)
                return i+1;
	return n+1;
    }
}