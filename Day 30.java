// Day 30 of 30 Days Leetcode.

// Problem Number 2418: Sort the People.

class Solution {
  public String[] sortPeople(String[] names, int[] heights) {
    List<Pair<Integer, String>> heightAndNames = new ArrayList<>();

    for (int i = 0; i < names.length; ++i)
      heightAndNames.add(new Pair<>(heights[i], names[i]));

    Collections.sort(heightAndNames, (a, b) -> b.getKey() - a.getKey());

    for (int i = 0; i < heightAndNames.size(); ++i)
      names[i] = heightAndNames.get(i).getValue();

    return names;
  }
}
