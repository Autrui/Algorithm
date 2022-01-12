package com.dwg.lintcode;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Autrui
 * @date 2021/12/24
 * @apiNote
 */
public class No2272Test {
	@Test
	public void solution () {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		System.out.println(Math.max(Math.max(a, b), c));
	}
}
