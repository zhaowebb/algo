class Solution {
    List<List<String>> res = new ArrayList<>();
    private void bt(int r, boolean[] cols, boolean[] dia, boolean[] antiDia, List<String> temp){
        if(temp.size() == cols.length) res.add(new ArrayList<>(temp));
        else{
            for(int c = 0; c < cols.length; c++){
                int dia_index = r - c + cols.length;
                int antiDia_index = 2 * cols.length - r - c - 1;
                if(!cols[c] && !dia[dia_index] && !antiDia[antiDia_index]){
                    char[] row = new char[cols.length];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
                    temp.add(new String(row));
                    cols[c] = true; dia[dia_index] = true; antiDia[antiDia_index] = true;
                    bt(r+1, cols, dia, antiDia, temp);
                    temp.remove(temp.size()-1);
                    cols[c] = false; dia[dia_index] = false; antiDia[antiDia_index] = false;
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        bt(0, new boolean[n], new boolean[2*n], new boolean[2*n], new ArrayList<>());
        return res;
    }
    
}

