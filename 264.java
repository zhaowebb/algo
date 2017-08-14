public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMulOf2 = 2, nextMulOf3 = 3, nextMulOf5 = 5;
        
        for(int i = 1; i < n; i++){
            int next = Math.min(nextMulOf2, Math.min(nextMulOf3, nextMulOf5));
            res[i] = next;
            
            if(next == nextMulOf2){
                i2++;
                nextMulOf2 = res[i2] * 2;
            }
            
            if(next == nextMulOf3){
                i3++;
                nextMulOf3 = res[i3] * 3;
            }
            
            if(next == nextMulOf5){
                i5++;
                nextMulOf5 = res[i5] * 5;
            }
            
        }
        return res[n-1];
    }
}