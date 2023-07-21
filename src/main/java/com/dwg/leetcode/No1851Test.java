package com.dwg.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Autrui
 * @date 2023/7/18
 * @apiNote
 */
public class No1851Test {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Integer[] qIndex = new Integer[n];
        for (int i = 0; i < n; ++i) {
            qIndex[i] = i;
        }
        Arrays.sort(qIndex, Comparator.comparingInt(i -> queries[i]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(qIndex, (i, j) -> queries[i] - queries[j]);
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int qi : qIndex) {
            while (i < intervals.length && intervals[i][0] <= queries[qi]) {
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                ++i;
            }
            while (!pq.isEmpty() && pq.peek()[2] < queries[qi]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans[qi] = pq.peek()[0];
            }
        }
        return ans;
    }
}
