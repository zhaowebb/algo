public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s2.length() - s1.length();
            }
        });
        for(int i = 0, j; i < strs.length; i++){
            boolean flag = true;
            for(j = 0; j < strs.length; j++){
                if(i == j) continue;
                if(isSubsequence(strs[i], strs[j])){
                    flag = false;
                    break;
                }
            }
            if(flag) return strs[i].length();
        }
        return -1;
    }
    
    public boolean isSubsequence(String s1, String s2){
        int j = 0;
        for(int i = 0; i < s2.length() && j < s1.length(); i++){
            if(s2.charAt(i) == s1.charAt(j)){
                j++;
            }
        }
        return j == s1.length();
    }
}