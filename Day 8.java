// Day 7 of 30 Days Leetcode.

// Problem Number 1579: Remove Max number of edges to keep graph fully traversable.

class UnionFind {
  private int count;
  private int[] parent, rank;

  public UnionFind(int n) {
    count = n;
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; ++i) parent[i] = i;
  }

  public boolean union(int u, int v) {
    int rootU = find(u), rootV = find(v);
    if (rootU == rootV) return false;
    if (rank[rootU] < rank[rootV]) parent[rootU] = rootV;
    else if (rank[rootU] > rank[rootV]) parent[rootV] = rootU;
    else { parent[rootV] = rootU; rank[rootU]++; }
    count--;
    return true;
  }

  public int getCount() { return count; }

  private int find(int u) {
    if (parent[u] != u) parent[u] = find(parent[u]);
    return parent[u];
  }
}

class Solution {
  public int maxNumEdgesToRemove(int n, int[][] edges) {
    UnionFind alice = new UnionFind(n), bob = new UnionFind(n);
    int requiredEdges = 0;
    Arrays.sort(edges, (a, b) -> b[0] - a[0]);

    for (int[] edge : edges) {
      int type = edge[0], u = edge[1] - 1, v = edge[2] - 1;
      if (type == 3) {
        boolean a = alice.union(u, v);
        boolean b = bob.union(u, v);
        if (a || b) requiredEdges++;
      } else if (type == 2) {
        if (bob.union(u, v)) requiredEdges++;
      } else if (type == 1) {
        if (alice.union(u, v)) requiredEdges++;
      }
    }

    return (alice.getCount() == 1 && bob.getCount() == 1) ? edges.length - requiredEdges : -1;
  }
}

