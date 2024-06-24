// Day 1 of 30 days Leetcode.

// Problem Number 1438 : Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit


class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 1;
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();

        for (int l = 0, r = 0; r < nums.length; ++r) {
            while (!minQ.isEmpty() && minQ.peekLast() > nums[r])
                minQ.pollLast();
            minQ.offerLast(nums[r]);

            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[r])
                maxQ.pollLast();
            maxQ.offerLast(nums[r]);

            while (maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if (minQ.peekFirst() == nums[l])
                    minQ.pollFirst();
                if (maxQ.peekFirst() == nums[l])
                    maxQ.pollFirst();
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
