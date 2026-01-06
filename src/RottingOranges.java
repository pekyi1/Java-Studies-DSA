import java.util.Queue;
import java.util.LinkedList;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize queue with all rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges exist
        if (freshCount == 0) return 0;

        int minutes = 0;

        // Directions: up, down, left, right
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Check bounds and fresh orange
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // rot it
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) {
                minutes++;
            }
        }

        // Step 3: Check if all fresh oranges are rotted
        return freshCount == 0 ? minutes : -1;
    }

    // Test the solution
    public static void main(String[] args) {
        int[][] grid1 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int[][] grid2 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };

        System.out.println(orangesRotting(grid1)); // Output: 4
        System.out.println(orangesRotting(grid2)); // Output: -1
    }
}
