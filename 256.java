public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        int[][] dp = costs;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < 3; j++){
                dp[i][j] = dp[i][j] + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
            }
        }
        return Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1], dp[dp.length-1][2]));
    }
}