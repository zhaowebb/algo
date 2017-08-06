public class Solution {
    public int numSquares(int n) {
        int rows = (int) Math.sqrt(n) + 1;
        int[][] dp = new int[rows][n+1];
        
        for(int j = 0; j <= n; j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i < rows; i++){
            for(int j = 1; j <= n; j++){
                if(j < i*i){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-i*i] + 1, dp[i-1][j]);
                }
            }
        }
        
        return dp[rows-1][n];
    }
}