package leetcode.L1769;

import java.util.Arrays;

public class Solution {

    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    sum += Math.abs(j - i);
                }
            }


            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        String boxes = "001011";
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.minOperations(boxes)));
    }
}
