/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.*/


class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set= new HashSet<>();
       for(int num : nums) {
        set.add(num);
       }
       int longest=0;
       int res=0;
       for(int num : nums){
         if(!set.contains(num-1)){
            int current= num;
            res=1;

            while(set.contains(current+1)){
                current++;
                res++;
            }
         }
       }
       return Math.max(res,longest);
    }
}
