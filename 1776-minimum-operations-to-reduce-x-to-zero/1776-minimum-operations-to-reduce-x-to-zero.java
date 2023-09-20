class Solution {
      public  int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum == x) {
            return nums.length;
        }

        int tempSum = sum - x;
        int max = 0;
        int curr = 0;
        int start = 0;
        int temp = 0;
        while (curr < nums.length) {
            temp = temp + nums[curr];
            while (start<curr&&temp > tempSum) {
                temp = temp - nums[start];
                start++;
            }
            if (tempSum == temp) {
                max = Math.max(max, curr - start + 1);
            }
            curr++;
        }

        return max == 0 ? -1 : nums.length - max;
	}
}