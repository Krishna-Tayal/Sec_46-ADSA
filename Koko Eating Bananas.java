/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=0;
        for(int p : piles){
            max=Math.max(max,p);
        }
        int left=1;
        int right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(totalhrs(piles,mid,h)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean totalhrs(int[] piles, int m, int hrs){
        long total=0L;
        for(int pile : piles){
            total+= (pile+m -1)/m;
            if(total>hrs){
                return false;
            }
        }
        return total<=hrs;
    }
}
