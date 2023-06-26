package com.dwg.classtest.streamdfs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * A tree node data model used for DFS traversal stream generators
 */
@Data
@AllArgsConstructor
public class TreeNode<T> {
    private final T value;
    private final int level;
    private final TreeNode<T> parentNode;

    public TreeNode(TreeDfsStackHead<T> treeDfsStackHead) {
        this.value = treeDfsStackHead.getSiblingIterator().next();
        this.level = treeDfsStackHead.getNode().getLevel();
        this.parentNode = treeDfsStackHead.getNode().getParentNode();
    }

    /**
     * Return a stream that contains all parent (ancestor) nodes back to the root, not include the current node.
     */
    public Stream<TreeNode<T>> getParentStream() {
        if (Objects.isNull(parentNode)) {
            return Stream.empty();
        } else {
            return Stream.iterate(this.getParentNode(), Objects::nonNull, TreeNode::getParentNode);
        }
    }

    /**
     * Return a stream that contains nodes in the path from the root, including the current node.
     * This method is less performance, if you don't care about top-down order, use {@link #getParentStream()} instead.
     */
    public Stream<TreeNode<T>> getPath() {
        return Stream.concat(
                // parent nodes in reverse order
                StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                                getParentStream()
                                        .collect(Collectors.toCollection(LinkedList::new))
                                        .descendingIterator(),
                                Spliterator.ORDERED
                        ),
                        false
                ),
                // followed by the current node
                Stream.of(this)
        );
    }

}
