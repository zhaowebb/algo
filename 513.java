/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxLev = -1;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    public void dfs(TreeNode root, int lev){
        if(root == null) return;
        dfs(root.left, lev + 1);
        if(lev > maxLev){
            maxLev = lev;
            res = root.val;
        }
        dfs(root.right, lev+1);
    }
}