package com.dwg.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Autrui
 * @date 2021/12/24
 * @apiNote
 */
public class No0376Test {
	@Test
	public void solution () {

	}

	/**
	 * @param root: the root of binary tree
	 * @param target: An integer
	 * @return: all valid paths
	 */
	public List<List<Integer>> binaryTreePathSum (TreeNode root, int target) {
		// write your code here
		List<List<Integer>> res = new ArrayList<>();
		Stack<TreeNode> treeNodes = new Stack<>();
		
		return res;
	}


	/**
	 * Definition of TreeNode:
	 */
	public static class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode (int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

}
