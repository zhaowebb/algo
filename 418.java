public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int start = 0; 
        StringBuilder sb = new StringBuilder();
        for(String str : sentence){
            sb.append(str);
            sb.append(" ");
        }
        String sen = sb.toString();
        int len = sen.length();
        for(int i = 0; i < rows; i++){
            start += cols;
            if(sen.charAt(start % len) == ' '){
                start++;
            }
            else{
                while(start > 0 && sen.charAt((start - 1) % len) != ' '){
                    start--;
                }
            }
        }
        
        return start / sen.length();
    }
}