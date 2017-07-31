public class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0, d1 = 0, d2 = 0;
        
        while(i < len1 || j < len2){
            while(i < len1 && version1.charAt(i) != '.'){
                d1 = d1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            
            while(j < len2 && version2.charAt(j) != '.'){
                d2 = d2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            
            if(d1 > d2) return 1;
            else if(d1 < d2) return -1;
            d1 = 0;
            d2 = 0;
            i++;
            j++;
        }
        
        return 0;
    }
}