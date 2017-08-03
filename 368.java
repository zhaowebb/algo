public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxInd = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxInd = dp[maxInd] > dp[i] ? maxInd : i;
                }
            }
        }
        
        int temp = nums[maxInd];
        int cur = dp[maxInd];
        
        for(int i = maxInd; i >= 0; i--){
            if(temp % nums[i] == 0 && dp[i] == cur){
                res.add(nums[i]);
                temp = nums[i];
                cur--;
            }
        }
        
        return res;
    }
}