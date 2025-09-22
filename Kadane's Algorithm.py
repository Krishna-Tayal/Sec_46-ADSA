# You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].

# Note : A subarray is a continuous part of an array.

# Examples:

# Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
# Output: 11
# Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
# Input: arr[] = [-2, -4]
# Output: -2
# Explanation: The subarray [-2] has the largest sum -2.
# Input: arr[] = [5, 4, 1, 7, 8]
# Output: 25
# Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.


class Solution:
    def maxSubarraySum(self, arr):
        # Code here
        n= len(arr)
        dp=[None]*n
        dp[0]=arr[0]
        
        for i in range(1,n):
            sum=dp[i-1]+arr[i]
            if sum > arr[i]:
                dp[i]=sum
            else:
                dp[i]=arr[i]
                
        return max(dp)
