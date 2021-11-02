class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer low = treeSet.floor(nums[i]);   // get the greatest element smaller than this number
            Integer high = treeSet.ceiling(nums[i]);  // get the smallest element greater than this number

            if ((low != null && (long) nums[i] - low <= t) || (high != null && (long) high - nums[i] <= t)) {   // check for absolute differences
                return true;
            }
            treeSet.add(nums[i]);

            if (i >= k) {   // remove the first element when size of the tree set exceeds K
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}