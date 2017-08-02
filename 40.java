public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        recursion(candidates, 0, target, new ArrayList<>());
        return res;
    }
    
    private void recursion(int[] candidates, int start, int target, List<Integer> path){
        if(target < 0){
            return;
        }
        else if(target == 0){
            res.add(new ArrayList<>(path));
        }
        else{
            for(int i = start; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i-1]) continue;
                path.add(candidates[i]);
                recursion(candidates, i + 1, target - candidates[i], path);
                path.remove(path.size()-1);
            }
        }
    }
}