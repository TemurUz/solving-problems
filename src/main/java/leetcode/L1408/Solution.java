package leetcode.L1408;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<String> stringMatching(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int n = words.length;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = {"leetcode", "et", "code"};
        Solution solution = new Solution();
        System.out.println(solution.stringMatching(words));
    }
}
