public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] cnt = new int[26];
        int maxLen = 0;
        for(int i = 0; i < p.length(); i++){
            if(i > 0 && (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i-1) - p.charAt(i) == 25)){
                maxLen++;
            }
            else{
                maxLen = 1;
            }
            
            cnt[p.charAt(i) - 'a'] = Math.max(maxLen, cnt[p.charAt(i) - 'a']);
        }
        
        int sum = 0;
        for(int n : cnt){
            sum += n;
        }
        return sum;
    }
}