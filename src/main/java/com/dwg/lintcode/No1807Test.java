package com.dwg.lintcode;

import org.junit.Test;

/**
 * @author Autrui
 * @date 2022/1/5
 * @apiNote
 */
public class No1807Test {
	@Test
	public void solution(){
		System.out.println(fibonacci(6));
	}

	public int fibonacci(int n) {
		// write your code here
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		if (n > 2) {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		return -1;
	}
}
