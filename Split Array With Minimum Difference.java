/*You are given an integer array nums.

Split the array into exactly two subarrays, left and right, such that left is strictly increasing and right is strictly decreasing.

Return the minimum possible absolute difference between the sums of left and right. If no valid split exists, return -1.

 

Example 1:

Input: nums = [1,3,2]

Output: 2*/

class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        if (n < 2) return -1;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        boolean[] inc = new boolean[n];
        inc[0] = true;
        for (int i = 1; i < n; i++) {
            inc[i] = inc[i - 1] && nums[i] > nums[i - 1];
        }

        boolean[] dec = new boolean[n];
        dec[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            dec[i] = dec[i + 1] && nums[i] > nums[i + 1];
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (inc[i] && dec[i + 1]) {
                long leftSum = prefix[i + 1];
                long rightSum = prefix[n] - prefix[i + 1];
                ans = Math.min(ans, Math.abs(leftSum - rightSum));
            }
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}
