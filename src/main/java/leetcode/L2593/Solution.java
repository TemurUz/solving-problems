package leetcode.L2593;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public long findScore(int[] nums) {
        long score = 0; // Use long to avoid overflow

        Deque<Integer> q = new LinkedList<>();

        // Traverse through the array
        for (int num : nums) {
            // If queue is not empty and the current number is greater than or equal to the last in queue
            if (!q.isEmpty() && num >= q.peekLast()) {
                boolean skip = false;
                // Process the elements in the queue
                while (!q.isEmpty()) {
                    int add = q.pollLast();
                    if (!skip) {
                        score += add;
                    }
                    skip = !skip;
                }
                continue;
            }

            // Add current element to the queue
            q.addLast(num);
        }

        // Final processing of remaining elements in the queue
        boolean skip = false;
        while (!q.isEmpty()) {
            int add = q.pollLast();
            if (!skip) {
                score += add;
            }
            skip = !skip;
        }

        return score;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 6, 10};
        Solution solution = new Solution();
        System.out.println(solution.findScore(nums));
    }
}