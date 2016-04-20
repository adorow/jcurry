import jcurry.Curry;

import java.util.function.BiFunction;


// todo: add junit4, hamcrest
/**
 * Created by Anderson on 19/04/2016.
 */
public class CurryTest {

    public static void main(String[] args) {
//        Curry.<Integer, Void>curry(CurryTest::print).compose(curry(CurryTest.add(), 1)).apply(5);
//        curryVoid(System.out::print);
//        curryVoid(System.out::print, curry(CurryTest.add(), 1));
//        curry(new Something()::str1, 1);
        //curry((Integer a, Integer b) -> a + b, 1);

        System.out.print(Curry.as(new Something()::str1).apply(4));
    }

    private static BiFunction<Integer, Integer, Integer> add() {
        return (Integer a, Integer b) -> a + b;
    }

    static class Something {

        public Integer str1(Integer a) {
            return a;
        }

        public Integer str2(Integer a, Integer b) {
            return a;
        }


    }

    private static Void print(Object o) {
        System.out.print(o);
        return null;
    }
}
