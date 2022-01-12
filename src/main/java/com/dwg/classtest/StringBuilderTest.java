package com.dwg.classtest;

import org.junit.Test;

/**
 * @author Autrui
 * @date 2022/1/5
 * @apiNote
 */
public class StringBuilderTest {
	@Test
	public void test () {
		StringBuilder s = new StringBuilder("abcdefg");
		//s.insert(1, "xxx");
		s.delete(2,3);
		System.out.println(s);
	}
}
