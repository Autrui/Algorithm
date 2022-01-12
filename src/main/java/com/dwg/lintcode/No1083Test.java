package com.dwg.lintcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Autrui
 * @date 2021/12/23
 * @apiNote
 */
public class No1083Test {

	@Test
	public void solution () {
		int[] nums = new int[]{1, 2, 1, 2, 6, 7, 5, 1};
		int k = 2;
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(nums, k)));
	}

	public int[] maxSumOfThreeSubarrays (int[] nums, int k) {
		int n = nums.length, maxsum = 0;
		int[]   sum = new int[n + 1],
				posLeft = new int[n],
				posRight = new int[n],
				ans = new int[3];
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
			int i1 = sum[i + 1] - sum[i + 1 - k];
			if (i1 > tot) {
				posLeft[i] = i + 1 - k;
				tot = i1;
			} else {
				posLeft[i] = posLeft[i - 1];
			}
		}
		posRight[n - k] = n - k;
		for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; i--) {
			int i1 = sum[i + k] - sum[i];
			if (i1 >= tot) {
				posRight[i] = i;
				tot = i1;
			} else {
				posRight[i] = posRight[i + 1];
			}
		}
		for (int i = k; i <= n - 2 * k; i++) {
			int l = posLeft[i - 1], r = posRight[i + k];
			int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
			if (tot > maxsum) {
				maxsum = tot;
				ans[0] = l;
				ans[1] = i;
				ans[2] = r;
			}
		}
		return ans;
	}
}
