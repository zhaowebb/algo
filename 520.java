public class Solution {
    public boolean detectCapitalUse(String word) {
        int num_lowers = 0;
        for(char c : word.toCharArray()){
            if(!Character.isUpperCase(c)){
                num_lowers++;
            }
        }
        return num_lowers == 0 || num_lowers == word.length() || (num_lowers == word.length() - 1 && Character.isUpperCase(word.charAt(0)));
    }
}