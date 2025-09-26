/*Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

 

Example 1:

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Example 2:

Input: nums = [4,2,3,4]
Output: 4*/


class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=0;

        for(int k=n-1;k>=2;k--){
            int left=0;
            int right=k-1;
            while(left<right){
                if(nums[left]+nums[right] > nums[k]){
                    ans+=(right-left);
                    right--;
                }
                else{
                    left++;
                }   
            }
        }
        return ans;
    }
}
