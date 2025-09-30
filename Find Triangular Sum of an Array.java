/*You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).

The triangular sum of nums is the value of the only element present in nums after the following process terminates:

Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
Replace the array nums with newNums.
Repeat the entire process starting from step 1.
Return the triangular sum of nums.*/

class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] newnums= nums;
        while(newnums.length!=1){
            newnums=calculate(newnums);
        }
        return newnums[0];
    }
    private int[] calculate(int[] cal){
        int i=0;
        int[] newcal=new int[cal.length-1];
        while(i<cal.length-1){
            newcal[i]= (cal[i]+cal[i+1]) %10;
            i++;
        }
        return newcal;
    }
}
