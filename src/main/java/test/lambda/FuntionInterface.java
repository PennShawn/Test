package test.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Function: 接收参数，并返回结果，主要方法 R apply(T t)
 * Consumer: 接收参数，无返回结果, 主要方法为 void accept(T t)
 * Supplier: 不接收参数，但返回结构，主要方法为 T get()
 * Predicate: 接收参数，返回boolean值，主要方法为 boolean test(T t)
 */
public class FuntionInterface {

    public static void main(String[] args) {
        //Function
        Function<Integer, String> toString = (a) -> {
            System.out.println("toString");
            return a.toString();
        };
        Function<String, Boolean> print = (a) -> {
            System.out.println(a);
            return true;
        };

        toString.andThen(print).apply(123);

        Function.identity().apply(123);

        //Predicate
        Predicate<Integer> greater = (a) -> {
            return a > 10;
        };

        Predicate<Integer> smaller = (a) -> {
            return a < 10;
        };

        greater.or(smaller).test(123);

        //Consumer
        Consumer<Integer> consumer = (a) -> {
            System.out.println(a);
        };

        Consumer<Integer> printDouble = (a) -> {
            System.out.println(a + a);
        };

        consumer.andThen(printDouble).accept(1);

        //Supplier
        Supplier<Integer> one = () -> {
            return 1;
        };

        Supplier<Integer> two = () -> {
            return 2;
        };
        System.out.println(one.get());
        System.out.println(two.get());

    }
}
