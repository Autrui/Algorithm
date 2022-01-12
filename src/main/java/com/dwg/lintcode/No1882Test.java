package com.dwg.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Autrui
 * @date 2022/1/10
 * @apiNote
 * 现在给你两个长度均为N的整数数组 A 和 B 。
 * 当(A[0]+...A[K-1])，(A[K]+...+A[N-1])，(B[0]+...+B[K-1]) 和 (B[K]+...+B[N-1])四个和值大小相等时，称索引K是一个公平索引。也就是说，索引K 可以使得A， B 两个数组被分成两个非空数组，这四个子数组的和值相等。
 * 例如，数组A = [4,-1,0,3]，B = [-2,5,0,3]，那么索引 K = 2是公平的，子数组的和相等：4+(-1) = 3; 0+3 = 3; -2 + 5 = 3 and 0 + 3 = 3。
 * 现在请你计算公平索引的个数。
 * 2<=N<=100000
 * -1000000000<=a[i],b[i]<=1000000000 (0<=i<N)
 */
public class No1882Test {
	@Test
	public void solution(){
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
	}

	public int CountIndexes(List<Integer> A, List<Integer> B) {
		// Write your code here.
		int length = A.size();
		long sumA = 0;
		long sumB = 0;
		for (int i = 0; i < length; i++) {
			sumA += A.get(i);
			sumB += B.get(i);
		}
		if (sumA != sumB) {
			return 0;
		}
		long countA = 0, countB = 0;
		int count = 0;
		for (int i = 0; i < length-1; i++) {
			countA += A.get(i);
			countB += B.get(i);
			if (countA == countB && countA == sumA - countA) {
				count++;
			}
		}
		return count;
	}
}
