class Solution {
    String res = "1";
    public String countAndSay(int n) {
        if(n <= 1){
            return res;
        }
        
        int ind = 0;
        StringBuilder next_res  = new StringBuilder();
        while(ind < res.length()){
            char c = res.charAt(ind);
            int cnt = 0;
            while(ind < res.length() && c == res.charAt(ind)){
                cnt++;
                ind++;
            }
            next_res.append(cnt);
            next_res.append(c);
        }
        res = next_res.toString();
        return countAndSay(n-1);
    }
}