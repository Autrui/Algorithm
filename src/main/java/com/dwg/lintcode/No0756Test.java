package com.dwg.lintcode;

import org.junit.Test;

/**
 * @author Autrui
 * @date 2022/1/10
 * @apiNote
 */
public class No0756Test {
	@Test
	public void solution () {

	}

	public long multiplyLists (ListNode l1, ListNode l2) {
		// write your code here
		long num1 = 0;
		long num2 = 0;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		while (temp1 != null) {
			num1 = num1 * 10 + temp1.val;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			num2 = num2 * 10 + temp2.val;
			temp2 = temp2.next;
		}
		return num1 * num2;
	}

	//Definition for ListNode
	public class ListNode {
		int val;
		ListNode next;

		ListNode (int x) {
			val = x;
			next = null;
		}
	}

}
