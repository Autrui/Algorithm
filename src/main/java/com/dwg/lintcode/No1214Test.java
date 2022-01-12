package com.dwg.lintcode;

import org.junit.Test;

/**
 * @author Autrui
 * @date 2021/12/30
 * @apiNote
 *
 * 描述
 * 给定一个用字符串S表示的许可证，其中仅仅包含了数字、字母和短横线。字符串被N个短横线“-”切分为了N+1组。
 * 给定一个数字K，要求重新整理字符串的格式，使得除了第一组之外的每个组正好K个字符，第一组长度可以比K小，
 * 但也至少要包含一个字符。此外，对于两个组之间必须要插入一个短横线，所有的小写字母都要转换为大写字母。
 */
public class No1214Test {
	@Test
	public void solution () {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
	}

	public String licenseKeyFormatting (String S, int K) {
		// write your code here
		S = S.toUpperCase();
		StringBuilder s = new StringBuilder("abc");

		String[] splitString = S.split("-");
		for (int i = 1; i < splitString.length; i++) {
			while (splitString[i].length() < K) {
				splitString[i] = splitString[i] + splitString[i + 1];
				for (int j = i+1; j < splitString.length - i-1; j++) {

				}
			}
		}
		String res = "";
		for (int i = 0; i < splitString.length - 1; i++) {
			res = res + splitString[i] + "-";
		}
		res += splitString[splitString.length - 1];
		return res;
	}
}
