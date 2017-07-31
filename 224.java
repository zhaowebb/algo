public class Solution {
    public int calculate(String s) {
        int len = s.length(), sign = 1, res = 0;
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0; i < len; i++){
            if(Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i) - '0';
                while(i+1 < len && Character.isDigit(s.charAt(i+1))){
                    sum = sum*10 + s.charAt(i+1) - '0';
                        i++;
                }
                res += sum*sign;
            }
            else if(s.charAt(i) == '+'){
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                stk.push(res);
                stk.push(sign);
                res = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                res = res*stk.pop() + stk.pop();
            }
        }
        return res;
    }
}