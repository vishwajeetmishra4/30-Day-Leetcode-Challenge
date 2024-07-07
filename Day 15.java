// Day 15 of 30 Days Leetcode.

// Problem Number 1518: Water Bottles.


class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numBottles = 9;
        int numExchange = 3;
        int result = solution.numWaterBottles(numBottles, numExchange);
        System.out.println("Number of water bottles drank: " + result);
    }
}
