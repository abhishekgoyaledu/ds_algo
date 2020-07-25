package learning.dynamic_programming.random_problems;

public class MinimumSumPath {
    public static void main(String[] args) {
        int [][]grid = {
                {0,1}, {1,0}
        };
        System.out.println(new MinimumSumPath().minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][]t = new int[m][n];
        t[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            t[0][i] = t[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            t[i][0] = t[i-1][0] + grid[i][0];
        }
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    t[i][j] = grid[i][j] + t[i][j-1];
                } else if (j == 0 && i != 0) {
                    t[i][j] = grid[i][j] + t[i-1][j];
                } else if (i == 0 && j == 0) {
                    t[i][j] = grid[i][j];
                } else {
                    t[i][j] = Math.min(t[i-1][j], t[i][j-1]) + grid[i][j];
                }
            }
        }
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; j++) {
                System.out.print(t[i][j] + "  ");
            }
            System.out.println();
        }
        return t[m-1][n-1];
    }
}
