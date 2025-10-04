/*You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.*/

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        
        for (int[] w : walls) grid[w[0]][w[1]] = 1;
        
        for (int[] g : guards) grid[g[0]][g[1]] = 2;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        
        for (int[] g : guards) {
            int gr = g[0], gc = g[1];
            for (int[] d : dirs) {
                int r = gr + d[0], c = gc + d[1];
                while (r >= 0 && r < m && c >= 0 && c < n) {
                    
                    if (grid[r][c] == 1 || grid[r][c] == 2) break;
                    
                    grid[r][c] = 3;
                    r += d[0];
                    c += d[1];
                }
            }
        }

        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        return count;
    }
}
