/*You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.

You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).*/

class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], r = cur[1], c = cur[2];
            if (visited[r][c]) continue;       
            visited[r][c] = true;
            
            if (r == n - 1 && c == n - 1) return time;
            
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                
                int nextTime = Math.max(time, grid[nr][nc]);
                pq.offer(new int[]{nextTime, nr, nc});
            }
        }
        return -1;
    }
}
