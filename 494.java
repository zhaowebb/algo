public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0; 
        for(int n : nums){
            sum += n;
        }
        
        if(sum < S || (sum + S ) % 2 != 0){
            return 0;
        }
        
        int p = (sum + S) / 2;
        
        int[][] dp = new int[nums.length+1][p+1];
        
        dp[0][0] = 1;
        
        for(int i = 1; i <= nums.length; i++){
            dp[i][0] = nums[i-1] == 0 ? dp[i-1][0] * 2 : dp[i-1][0];
        }
        
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= p; j++){
                dp[i][j] = nums[i - 1] > j ? dp[i-1][j] : dp[i-1][j] + dp[i-1][j - nums[i-1]];
            }
        }
        
        return dp[nums.length][p];
    }
}