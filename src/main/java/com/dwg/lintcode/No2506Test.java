package com.dwg.lintcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Autrui
 * @date 2022/1/10
 * @apiNote
 * 描述
 * 你将得到一个由小写字母 a-z ，左括号 '(' 和右括号 ')' 构成的字符串 s。
 * 你的任务是删除尽可能少的括号，使得 s 里面的括号匹配。
 * 你需要返回删除括号后的字符串。
 * 由于答案可能会有很多，所以你只需要返回任意一个正确答案。
 *
 * 例如："()", "(())", "()()", "(())()" 是括号匹配的字符串， 而 ")(", "(()", "()()(", "()())" 则是括号不匹配的字符串。
 */
public class No2506Test {
	@Test
	public void solution(){

	}

	public String removeParentheses(String s) {
		// write your code here.
		Set<Integer> temp1 = new HashSet<>();
		Set<Integer> temp2 = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				temp1.add(i);
				continue;
			}
			if (s.charAt(i) == ')') {
				temp2.add(i);
				continue;
			}
		}
		return "";
	}
}
