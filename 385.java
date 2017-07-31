public class Solution {
    private char[] src;
    private int pos;
    
    public NestedInteger deserialize(String s) {
        src = s.toCharArray();
        pos = 0;
        return parseNestedInteger();
    }
    
    private NestedInteger parseNestedInteger() {
        if (src[pos] == '-' || src[pos] >= '0' && src[pos] <= '9') {
            return parseInt();
        } else {
            pos++; // skip '['
            NestedInteger ni = new NestedInteger();
            while (src[pos] != ']') {
                ni.add(parseNestedInteger());
                if (src[pos] == ',') {
                    pos++; // skip ','
                }
            }
            pos++; // skip ']'
            return ni;
        }
    }
    
    private NestedInteger parseInt() {
        int flag = 1, num = 0;
        
        if (src[pos] == '-') {
            flag = -1;
            pos++;
        }
        
        while (pos < src.length && src[pos] >= '0' && src[pos] <= '9') {
            num = num * 10 + src[pos] - '0';
            pos++;
        }
        
        return new NestedInteger(flag * num);
    }
}