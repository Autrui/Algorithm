package com.dwg.classtest.streamdfs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Stream friendly immutable linked stack for DFS tree traversal
 * Instances should be treat immutable. DO NOT reassign its fields, use constructor only.
 *
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeDfsStackHead<T> {

    TreeNode<T> node;

    // An iterator from the children stream to find next sibling node
    Iterator<T> siblingIterator;

    // Keep track of the original children stream for clean up
    Stream<T> stream;

    TreeDfsStackHead<T> previousHead;
}
