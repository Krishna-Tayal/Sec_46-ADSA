/*You are given a string s consisting of characters 'U', 'D', 'L', and 'R', representing moves on an infinite 2D Cartesian grid.

'U': Move from (x, y) to (x, y + 1).
'D': Move from (x, y) to (x, y - 1).
'L': Move from (x, y) to (x - 1, y).
'R': Move from (x, y) to (x + 1, y).
You are also given a positive integer k.

You must choose and remove exactly one contiguous substring of length k from s. Then, start from coordinate (0, 0) and perform the remaining moves in order.

Return an integer denoting the number of distinct final coordinates reachable.

 

Example 1:

Input: s = "LUL", k = 1

Output: 2

Explanation:

After removing a substring of length 1, s can be "UL", "LL" or "LU". Following these moves, the final coordinates will be (-1, 1), (-2, 0) and (-1, 1) respectively. There are two distinct points (-1, 1) and (-2, 0) so the answer is 2.

Example 2:

Input: s = "UDLR", k = 4

Output: 1

Explanation:

After removing a substring of length 4, s can only be the empty string. The final coordinates will be (0, 0). There is only one distinct point (0, 0) so the answer is 1.

Example 3:

Input: s = "UU", k = 1

Output: 1

Explanation:

After removing a substring of length 1, s becomes "U", which always ends at (0, 1), so there is only one distinct final coordinate.*/

class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        
        int[] preX = new int[n+1], preY = new int[n+1];
        for (int i = 0; i < n; ++i) {
            preX[i+1] = preX[i];
            preY[i+1] = preY[i];
            char c = s.charAt(i);
            if (c == 'U') preY[i+1]++;
            else if (c == 'D') preY[i+1]--;
            else if (c == 'L') preX[i+1]--;
            else if (c == 'R') preX[i+1]++;
        }

        
        int[] sufX = new int[n+1], sufY = new int[n+1];
        for (int i = n-1; i >= 0; --i) {
            sufX[i] = sufX[i+1];
            sufY[i] = sufY[i+1];
            char c = s.charAt(i);
            if (c == 'U') sufY[i]++;
            else if (c == 'D') sufY[i]--;
            else if (c == 'L') sufX[i]--;
            else if (c == 'R') sufX[i]++;
        }

        
        HashSet<Long> seen = new HashSet<>();
        for (int i = 0; i <= n - k; ++i) {
            int x = preX[i] + sufX[i + k];
            int y = preY[i] + sufY[i + k];
            long key = (((long)x) << 32) ^ (y & 0xffffffffL);
            seen.add(key);
        }
        return seen.size();
    }
}
