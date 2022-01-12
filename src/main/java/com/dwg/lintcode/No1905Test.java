package com.dwg.lintcode;

import org.junit.Test;

import java.util.*;

/**
 * @author Autrui
 * @date 2022/1/5
 * @apiNote
 * 给出两个字符串 str 和 sub，你的任务是在 str 中完全删除那些在 sub 中存在的字符。
 *
 * 输入:
 * str="They are students"，sub="aeiou"
 * 输出:
 * "Thy r stdnts"
 */
public class No1905Test {
	@Test
	public void solution () {
		System.out.println(CharacterDeletion("They are students", "aeiou"));
	}

	public String CharacterDeletion (String str, String sub) {
		// write your code here
		Set<Character> s = new LinkedHashSet<>();
		Map temp = new HashMap<Integer, Character>();
		for (char c : sub.toCharArray()) {
			s.add(c);
		}
		String[] subs = s.toArray(new String[s.size()]);

		for (int i = 0; i < s.size(); i++) {
			str = str.replaceAll(s+"", "");
		}
		return str;
	}
}
