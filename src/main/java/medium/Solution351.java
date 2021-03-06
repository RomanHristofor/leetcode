package medium;

public class Solution351 {
  private int[][] jumps;
  private boolean[] visited;

  public int numberOfPatterns(int m, int n) {
    jumps = new int[10][10];
    jumps[1][3] = jumps[3][1] = 2;
    jumps[4][6] = jumps[6][4] = 5;
    jumps[7][9] = jumps[9][7] = 8;
    jumps[1][7] = jumps[7][1] = 4;
    jumps[2][8] = jumps[8][2] = 5;
    jumps[3][9] = jumps[9][3] = 6;
    jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
    visited = new boolean[10];
    int count = 0;
    count += DFS(1, 1, 0, m, n) * 4; // 1, 3, 7, 9 are symmetrical
    count += DFS(2, 1, 0, m, n) * 4; // 2, 4, 6, 8 are symmetrical
    count += DFS(5, 1, 0, m, n);
    return count;
  }

  private int DFS(int num, int len, int count, int m, int n) {
    if (len >= m) count++;
    len++;
    if (len > n) return count;
    visited[num] = true;
    for (int i = 1; i <= 9; i++) {
      if (!visited[i] && (jumps[num][i] == 0 || visited[jumps[num][i]])) {
        count = DFS(i, len, count, m, n);
      }
    }
    visited[num] = false;
    return count;
  }
}
