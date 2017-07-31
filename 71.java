public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stk = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for(String dir : path.split("/")){
            if(dir.equals("..") && !stk.isEmpty()){
                stk.pop();
            }
            else if(!skip.contains(dir)){
                stk.push(dir);
            }
        }
        
        String res = "";
        for (String dir : stk) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}