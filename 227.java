public class Solution {
    public int calculate(String s) {
        int len = s.length();
        int num = 0;
        Stack<Integer> stk = new Stack<>();
        char op = '+';
        
        for(int i = 0; i < len; i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len-1){
                if(op == '-'){
                    stk.push(-num);
                }
                else if(op == '+'){
                    stk.push(num);
                }
                else if(op == '*'){ 
                    stk.push(stk.pop() * num);
                }
                else if(op == '/'){
                    stk.push(stk.pop() / num);
                }
                op = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while(!stk.isEmpty()){
            res += stk.pop();
        }
        return res;
    }
}