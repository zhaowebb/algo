public class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notrob = 0;
        for(int n : nums){
            int temp = notrob;
            notrob = Math.max(notrob, rob);
            rob = temp + n;
        }
        
        return Math.max(rob, notrob);
    }
}