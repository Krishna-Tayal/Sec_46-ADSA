/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.*/


class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int maxLen = 0;

        for (int n : set) {              
            if (!set.contains(n - 1)) {     
                int current = n;
                int len = 1;
                while (set.contains(current + 1)) {
                    current++;
                    len++;
                }
                if (len > maxLen) maxLen = len;
            }
        }

        return maxLen;
    }
}
