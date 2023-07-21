package com.dwg.classtest;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Autrui
 * @date 2023/7/6
 * @apiNote
 */
public class Stream17Test {
    @Test
    public void test() {
        List<Person> personList = Arrays.asList(new Person("bob", 34), new Person("bob", 43),
                new Person("mary", 81), new Person("john", 12), new Person("bob", 22));

        System.out.println("list of person objects - " + personList);

        Stream<Person> personStream = personList.stream();

        Map<String, List<Person>> result = personStream.collect(Collectors.teeing(
                Collectors.filtering(p -> p.age % 2 == 0, Collectors.toList()),
                Collectors.filtering(p -> p.age % 2 != 0, Collectors.toList()),
                (res1, res2) -> {
                    Map<String, List<Person>> map = new HashMap<>();
                    map.put("EvenAgedPersons", res1);
                    map.put("OddAgedPersons", res2);
                    return map;
                }));

        System.out.println("Result of applying teeing - " + result);
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
