package com.dwg.lintcode;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author Autrui
 * @date 2021/12/23
 * @apiNote
 */
public class No0379Test {
	@Test
	public void solution () {

	}

	public String min (int [] nums) {
		int n = nums.length;
		String minnum = "";

		return null;
	}

	public static class Cmp implements Comparator<String> {
		@Override
		public int compare (String a, String b) {
			String ab = a + b;
			String ba = b + a;
			return ba.compareTo(ab);
		}
	}
}

