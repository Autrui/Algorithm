package com.dwg.classtest.streamdfs;

import com.dwg.classtest.streamdfs.entity.TreeDfsStackHead;
import com.dwg.classtest.streamdfs.entity.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Autrui
 * @date 2023/6/24
 * @apiNote https://zhuanlan.zhihu.com/p/82508008
 */

public class StreamTest {
    @Test
    public void test() {

    }

    /**
     * Return a {@link Stream} that retrieve {@link TreeNode} in a tree data structure in Depth-First-Search order. A {@link TreeNode} contains
     * the value of the node, depth (level) of the node in the tree and the parent node. It also provide convenient methods to find out all the
     * ancestor nodes and the path from the root node to the current node.
     *
     * @param root              root node of the tree
     * @param childrenGenerator lambda function to return children stream for a given node
     */
    public static <T> Stream<TreeNode<T>> dfsTreeNodeStream(T root, Function<TreeNode<T>, Stream<T>> childrenGenerator) {
        // TreeDfsStackHead object should be treated immutable in this method, DO NOT reassign its fields, use constructor only
        return Stream.iterate(
                        new TreeDfsStackHead<>(new TreeNode<>(root, 1, null), Collections.emptyIterator(), Stream.empty(), null),
                        Objects::nonNull,
                        stack -> {
                            final Stream<T> children = childrenGenerator.apply(stack.getNode());
                            if (Objects.nonNull(children)) {
                                final Iterator<T> cit = children.iterator();
                                if (cit.hasNext()) {
                                    // has children, push first child to stack
                                    return new TreeDfsStackHead<>(new TreeNode<>(cit.next(), stack.getNode().getLevel() + 1, stack.getNode()), cit, children, stack);
                                }
                            }
                            // leaf, backtrack to find closest node in stack that has sibling or until stack is empty
                            final Optional<TreeDfsStackHead<T>> nextHeadHasSibling = Stream.iterate(
                                            stack,
                                            Objects::nonNull,  // stop at root
                                            head -> {
                                                if (head.getSiblingIterator().hasNext()) {
                                                    return head;
                                                } else {
                                                    // pop stack
                                                    head.getStream().close();
                                                    return head.getPreviousHead();
                                                }
                                            }
                                    )
                                    .dropWhile(s -> !s.getSiblingIterator().hasNext())
                                    .findFirst();
                            // if found, get the next sibling
                            return nextHeadHasSibling
                                    .map(s -> new TreeDfsStackHead<>(new TreeNode<>(s), s.getSiblingIterator(), s.getStream(), s.getPreviousHead()))
                                    .orElse(null);  // if not found, finish travelling, null value stops the iteration
                        })
                .map(TreeDfsStackHead::getNode);
    }

//    /**
//     * A tree node data model used for DFS traversal stream generators
//     */
//    public record TreeNode<T>(T value, int level, StreamTest.TreeNode<T> parentNode) {
//        /**
//         * Return a stream that contains all parent (ancestor) nodes back to the root, not include the current node.
//         */
//        public Stream<TreeNode<T>> getParentStream() {
//            if (this.parentNode() == null) {
//                return Stream.empty();
//            } else {
//                return Stream.iterate(this.parentNode(), Objects::nonNull, TreeNode::parentNode);
//            }
//        }
//
//        /**
//         * Return a stream that contains nodes in the path from the root, including the current node.
//         * This method is less performance, if you don't care about top-down order, use {@link #getParentStream()} instead.
//         */
//        public Stream<TreeNode<T>> getPath() {
//            return Stream.concat(
//                    // parent nodes in reverse order
//                    StreamSupport.stream(
//                            Spliterators.spliteratorUnknownSize(
//                                    getParentStream()
//                                            .collect(Collectors.toCollection(LinkedList::new))
//                                            .descendingIterator(),
//                                    Spliterator.ORDERED
//                            ),
//                            false
//                    ),
//                    // followed by the current node
//                    Stream.of(this)
//            );
//        }
//    }

//    /**
//     * Stream friendly immutable linked stack for DFS tree traversal
//     * Instances should be treat immutable. DO NOT reassign its fields, use constructor only.
//     *
//     * @param <T>
//     */
//    private static class TreeDfsStackHead<T> {
//        TreeNode<T> node;
//        Iterator<T> siblingIterator; // An iterator from the children stream to find next sibling node
//        Stream<T> stream; // Keep track of the original children stream for clean up
//        TreeDfsStackHead<T> previousHead;
//
//        TreeDfsStackHead(TreeNode<T> node, Iterator<T> siblingIterator, Stream<T> steram, TreeDfsStackHead<T> previousHead) {
//            this.node = node;
//            this.stream = steram;
//            this.siblingIterator = siblingIterator;
//            this.previousHead = previousHead;
//        }
//    }
}

