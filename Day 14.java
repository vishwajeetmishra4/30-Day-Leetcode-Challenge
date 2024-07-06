// Day 14 of 30 Days Leetcode.

// Problem Number 2582: Pass the Pillow

class Solution {
  public int passThePillow(int n, int time) {
    time %= (n - 1) * 2;
    if (time < n) // from 1 to n.
      return 1 + time;
    return n - (time - (n - 1)); // from n to 1.
  }
}
