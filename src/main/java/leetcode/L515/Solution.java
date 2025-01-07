package leetcode.L515;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    int [] arr = new int[10000];
    int maxLevel;

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Arrays.fill(arr, Integer.MIN_VALUE);

        dfs(root, 0);

        List<Integer> list=new ArrayList<>();
        for(int i=0; i<maxLevel+1; i++){
            list.add(arr[i]);
        }

        return list;
    }

    void dfs(TreeNode root, int level) {
        if (root == null) return;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

        if(arr[level]<root.val){
            arr[level] = root.val;
        }

        maxLevel=Math.max(maxLevel, level);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        Solution solution = new Solution();
        System.out.println(solution.largestValues(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}