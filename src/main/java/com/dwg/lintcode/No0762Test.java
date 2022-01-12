package com.dwg.lintcode;

import org.junit.Test;

/**
 * @author Autrui
 * @date 2022/1/10
 * @apiNote
 * 给定两个序列 P 和 Q 。
 * 你可以对这对 P 这个序列修改不超过 k 个元素到任意的值，并要求两个修改后序列的最长公共子序列最长。
 */
public class No0762Test {
	@Test
	public void solution () {
		System.out.println(longestCommonSubsequence2(new int[]{1, 2, 3, 4, 5}, new int[]{5, 3, 1, 4, 2}, 1));
	}

	public int longestCommonSubsequence2 (int[] P, int[] Q, int k) {
		// Write your code here
		int m = P.length;
		int n = Q.length;
		int[][][] dp = new int[m + 1][n + 1][k + 1];
		/**
		 * dp[i][j][]的 i 和 j 从1开始，但是在数组中都对 i 和 j 的值-1赋值，然后
		 */
		// 第一层循环，遍历第一个数组P
		for (int i = 1; i < m + 1; ++i) {
			// 第二层循环，遍历第二个数组Q，将Q数组的内容和P数组进行对比
			for (int j = 1; j < n + 1; ++j) {
				// 当Q数组中的值与当前P数组的值相等时进入if
				if (P[i - 1] == Q[j - 1]) {
					// 前一数组的第三层数组的第0位置的数+1给现在数组的第三层数组的第0位置
					dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
				} else {
					//
					dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
				}
			}
		}

		for (int i = 1; i < m + 1; ++i) {
			for (int j = 1; j < n + 1; ++j) {
				for (int g = 1; g < k + 1; ++g) {
					if (P[i - 1] != Q[j - 1]) {
						dp[i][j][g] = Math.max(dp[i - 1][j][g], Math.max(dp[i][j - 1][g], dp[i - 1][j - 1][g - 1] + 1));
					} else {
						dp[i][j][g] = Math.max(dp[i - 1][j][g], Math.max(dp[i][j - 1][g], dp[i - 1][j - 1][g] + 1));
					}
				}
			}
		}
		return dp[m][n][k];
	}
}
