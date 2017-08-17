public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    
    private int rob(int[] nums, int start, int end){
        int rob = 0;
        int notrob = 0;
        for(int i = start; i <= end; i++){
            int temp = notrob;
            notrob = Math.max(rob, notrob);
            rob = temp + nums[i];
        }
        return Math.max(rob, notrob);
    }
}