public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        double[][][] dp = new double[N+1][m][n];
        
        for(int k = 1; k <= N; k++){
            for(int r = 0; r < m; r++){
                for(int c = 0; c < n; c++){
                    dp[k][r][c] = ((r == 0 ? 1 : dp[k-1][r-1][c]) + (r == m - 1 ? 1 : dp[k-1][r+1][c]) + (c == 0 ? 1 : dp[k-1][r][c-1]) + (c == n - 1 ? 1 : dp[k-1][r][c+1])) % (Math.pow(10, 9) + 7);
                }
            }
        }
        return (int)dp[N][i][j];
    }
}
