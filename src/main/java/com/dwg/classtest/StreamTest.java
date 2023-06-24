package com.dwg.classtest;

import com.dwg.classtest.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Autrui
 * @date 2023/6/24
 * @apiNote
 */
@Slf4j
public class StreamTest {

    public static <T> Stream<T> dfsTreeStream(
            T root,
            Function<T, Stream<T>> childrenGenerator
    ) {
        return Stream.concat(
                Stream.of(root),
                childrenGenerator.apply(root).flatMap(child -> dfsTreeStream(child, childrenGenerator))
        );
    }

    @Test
    public void test() {

    }

}

