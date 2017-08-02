public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        recursion(candidates, 0, k, n, new ArrayList<>());
        return res;
    }
    
    private void recursion(int[] candidates, int start, int k, int n, List<Integer> path){
        if(path.size() == k && n == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(n < 0 || path.size() > k){
            return;
        }
        for(int i = start; i < 9; i++){
            path.add(candidates[i]);
            recursion(candidates, i + 1, k, n - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}