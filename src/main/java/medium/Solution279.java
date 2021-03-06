package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution279 {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j * j <= i; j++) {
        System.out.println("i="+i +"  j=" + j + " dp=" + dp[i]);
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }

    return dp[n];
  }

  @Test
  public void test() {
    assertEquals(numSquares(12), 3);
  }
}
