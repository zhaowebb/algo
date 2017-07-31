public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, cnt = 0;
        for(; j < abbr.length(); j++){
            char c = abbr.charAt(j);
            if(Character.isDigit(c)){
                if(cnt == 0 && c == '0'){
                    return false;
                }
                cnt = cnt * 10 + c - '0';
            }
            else{
                i += cnt;
                cnt = 0;
                if(i >= word.length() || word.charAt(i) != c){
                    return false;
                }
                i++;
            }
        }
        return i + cnt == word.length();
    }
}