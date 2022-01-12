package com.dwg.lintcode;

import org.junit.Test;

/**
 * @author Autrui
 * @date 2021/12/27
 * @apiNote
 */
public class No1821Test {
	@Test
	public void solution () {
		System.out.println(minDeletionsToObtainStringInRightFormat("AABBBB"));

	}

	public int minDeletionsToObtainStringInRightFormat (String s) {
		// write your code here
		int count = 0;
		int abAt = s.indexOf("AB");
		if (abAt == 0) {
			return 2;
		}
		String[] splitString = s.split("AB",2);
		if (splitString[0].indexOf("B") >= 0) {
			count++;
		}
		if (splitString[1].indexOf("A") >= 0) {
			count++;
		}
		if (splitString[0].indexOf("A") < 0 && splitString[1].indexOf("B") < 0) {
			count++;
		}
		return count;
	}
}
