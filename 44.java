class Solution {
    public boolean isMatch(String s, String p) {
        int sInd = 0, pInd = 0, starInd = -1, match = 0;
        
        while(sInd < s.length()){
            if(pInd < p.length() && (p.charAt(pInd) == '?' || p.charAt(pInd) == s.charAt(sInd))){
                pInd++;
                sInd++;
            }
            else if(pInd < p.length() && p.charAt(pInd) == '*'){
                match = sInd;
                starInd = pInd;
                pInd++;
            }
            else if(starInd != -1){
                pInd = starInd + 1;
                match++;
                sInd = match;
            }
            else{
                return false;
            }
        }
        
        while(pInd < p.length() && p.charAt(pInd) == '*'){
            pInd++;
        }
        return pInd == p.length();
    }
}