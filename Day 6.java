// Day 6 of 30 Days Leetcode.

// Problem Number : 2285 Maximum Total Importance of Roads.

import java.util.Arrays;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long ans = 0;
        long[] count = new long[n];

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            count[u]++;
            count[v]++;
        }

        Arrays.sort(count);

        for (int i = 0; i < n; i++) {
            ans += (i + 1) * count[i];
        }

        return ans;
    }
}
