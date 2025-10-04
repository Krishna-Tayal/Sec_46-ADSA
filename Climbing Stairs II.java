/*You are climbing a staircase with n + 1 steps, numbered from 0 to n.

You are also given a 1-indexed integer array costs of length n, where costs[i] is the cost of step i.

From step i, you can jump only to step i + 1, i + 2, or i + 3. The cost of jumping from step i to step j is defined as: costs[j] + (j - i)2

You start from step 0 with cost = 0.

Return the minimum total cost to reach step n.*/

class Solution {
    public int climbStairs(int n, int[] costs) {
        final long INF = Long.MAX_VALUE / 4;
        long[] last = new long[4]; // we'll use indices modulo 4
        Arrays.fill(last, INF);
        last[0] = 0; // dp[0]

        for (int j = 1; j <= n; j++) {
            long best = INF;
            for (int step = 1; step <= 3; step++) {
                int i = j - step;
                if (i >= 0) {
                    long dpi = last[i % 4];
                    long cost = dpi + (long)costs[j - 1] + (long)(j - i) * (j - i);
                    if (cost < best) best = cost;
                }
            }
            last[j % 4] = best;
        }
        return (int) last[n % 4];
    }
}
