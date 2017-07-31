public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        
        if(sum % 2 != 0){
            return false;
        }
        
        sum /= 2;
        
        boolean[][] dp = new boolean[nums.length][sum + 1];
        
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j <= sum; j++){
                dp[i][j] = nums[i] > j ? dp[i-1][j] : dp[i-1][j - nums[i]] || dp[i-1][j];
            }
        }
        
        return dp[nums.length-1][sum];
    }
}

