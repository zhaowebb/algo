public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        recursion(candidates, target, 0, path);
        return res;
    }
    
    private void recursion(int[] candidates, int target, int start, List<Integer> path){
        if(target < 0){
            return;
        }
        else if(target == 0){
            res.add(new ArrayList<>(path));
        }
        else{
            for(int i = start; i < candidates.length; i++){
                if (candidates[i] > target) {
                    break;
                }
                path.add(candidates[i]);
                recursion(candidates, target - candidates[i], i, path);
                path.remove(path.size()-1);
            }
        }
    }
}

