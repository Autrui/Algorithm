package com.dwg.classtest;

import org.junit.Test;

/**
 * @author Autrui
 * @date 2022/1/5
 * @apiNote
 */
public class StringTest {
	@Test
	public void replaceTest(){
		String temp = "They are students";
		temp = temp.replaceAll("a", "");
		System.out.println(temp);
	}
}
