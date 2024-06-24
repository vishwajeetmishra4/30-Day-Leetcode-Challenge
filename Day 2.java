// Day 2 of 30 Days Leetcode.

// Problem Number 995 : Minimum Number of K consecutive bit flips

import java.util.*;

public class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int ans = 0;
        int flippedTime = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i >= k && nums[i - k] == 2)
                --flippedTime;
            if (flippedTime % 2 == nums[i]) {
                if (i + k > nums.length)
                    return -1;
                ++ans;
                ++flippedTime;
                nums[i] = 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0};
        int k = 1;
        int result = solution.minKBitFlips(nums, k);
        System.out.println(result);  // Output: 2
    }
}
