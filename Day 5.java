// Day 5 of 30 Days Leetcode.

// Problem Number: 1791 Find the Centre of Star Graph.

class Solution {
    public int findCenter(int[][] edges) {
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
                ? edges[0][0]
                : edges[0][1];
    }
}
