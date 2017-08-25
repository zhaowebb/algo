public class Excel {
    class Cell{
        int val = 0;
        boolean isNum = true;
        String[] formula;
        
        public void setFormula(String[] formula){
            this.formula = formula;
            isNum = false;
        }
        
        public int calFormula(){
            int sum = 0;
            
            for(String str : formula){
                if(str.indexOf(":") >= 0){
                    int sep = str.indexOf(":");
                    int c1 = str.charAt(0) - 'A';
                    int r1 = Integer.parseInt(str.substring(1, sep)) - 1;
                    int c2 = str.charAt(sep+1) - 'A';
                    int r2 = Integer.parseInt(str.substring(sep+2)) - 1;
                    for(int i = r1; i <= r2; i++){
                        for(int j = c1; j <= c2; j++){
                            sum += table[i][j].isNum ? table[i][j].val : table[i][j].calFormula();
                        }
                    }
                }
                else{
                    int c1 = str.charAt(0) - 'A';
                    int r1 = Integer.parseInt(str.substring(1)) - 1;
                    sum += table[r1][c1].isNum ? table[r1][c1].val : table[r1][c1].calFormula();
                }
            }
            
            val = sum;
            return val;
        }
        
        public void setNum(int val){
            this.val = val;
            isNum = true;
        }
    }
    
    Cell[][] table;
    public Excel(int H, char W) {
        table = new Cell[H][W-'A'+1];
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++){
                table[i][j] = new Cell();
            }
        }
    }
    
    public void set(int r, char c, int v) {
        table[r-1][c-'A'].setNum(v);
    }
    
    public int get(int r, char c) {
        if(table[r-1][c-'A'].isNum){
            return table[r-1][c-'A'].val;
        }
        else{
            return table[r-1][c-'A'].calFormula();
        }
    }
    
    public int sum(int r, char c, String[] strs) {
        table[r-1][c-'A'].setFormula(strs);
        return table[r-1][c-'A'].calFormula();
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */