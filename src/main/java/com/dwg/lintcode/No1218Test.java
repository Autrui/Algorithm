package com.dwg.lintcode;

import org.junit.Test;

/**
 * @author Autrui
 * @date 2021/12/24
 * @apiNote
 */
public class No1218Test {
	@Test
	public void solution () {
		System.out.println(findComplement(5));
	}

	public int findComplement (int num) {
		// Write your code here
		//String temp = Integer.toBinaryString(num);
		//char[] chars = temp.toCharArray();
		//char[] solution = new char[chars.length];
		//for (int i = 0; i < chars.length; i++) {
		//	if (chars[i] == '1') {
		//		solution[i] = '0';
		//	} else if (chars[i] == '0') {
		//		solution[i] = '1';
		//	} else {
		//		break;
		//	}
		//}
		//return Integer.valueOf(String.valueOf(solution), 2);
		int c=1;
		while(c<num){
			c=(c<<1)+1;
		}
		return c-num;
	}
}
