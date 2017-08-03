public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return helper(dp, 1, n);
    }
    
    public int helper(int[][] dp, int start, int end){
        if(start >= end){
            return 0;
        }
        
        if(dp[start][end] != 0){
            return dp[start][end];
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int i = start; i < end; i++){
            int temp = i + Math.max(helper(dp, start, i-1), helper(dp, i+1, end));
            res = Math.min(res, temp);
        }
        dp[start][end] = res;
        return res;
    }
}