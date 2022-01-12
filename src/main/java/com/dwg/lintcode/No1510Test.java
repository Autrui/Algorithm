package com.dwg.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Autrui
 * @date 2021/12/24
 * @apiNote
 */
public class No1510Test {
	@Test
	public void solution () {
		String a = "aa";
		String b = "aa";
		System.out.println(buddyStrings(a, b));
	}

	public boolean buddyStrings (String A, String B) {
		// Write your code here
		if (A.length() != B.length()) {
			return false;
		}

		if (A.equals(B)) {
			Set<Character> s = new HashSet<>();
			for (char c : A.toCharArray()) {
				s.add(c);
			}
			return s.size() < A.length();
		}

		List<Integer> dif = new ArrayList<>();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				dif.add(i);
			}
		}

		return dif.size() == 2 &&
				A.charAt(dif.get(0)) == B.charAt(dif.get(1)) &&
				A.charAt(dif.get(1)) == B.charAt(dif.get(0));
	}
}
