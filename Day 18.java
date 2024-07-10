// Day 18 of 30 Days Leetcode.

// Problem Number 1598: Crawler Log Folder

class Solution {
  public int minOperations(String[] logs) {
    int ans = 0;

    for (final String log : logs) {
      if (log.equals("./"))
        continue;
      if (log.equals("../"))
        ans = Math.max(0, ans - 1);
      else
        ++ans;
    }

    return ans;
  }
}
