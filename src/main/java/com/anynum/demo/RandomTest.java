package com.anynum.demo;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author guopeng.Zgp 2022.05.06
 */
public class RandomTest {

    public static void main(String[] args) {

//        System.out.println(randomString(-229985452) + " " + randomString(-147909649));

//        System.out.println(generateSeed("dumb", Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println(generateSeed("code", Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println(generateSeed("", Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println(generateSeed("", Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println(generateSeed("", Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println(generateSeed("", Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println(generateSeed("", Integer.MIN_VALUE, Integer.MAX_VALUE));

//        Integer[] seeds = {-2144508782,-2143273669};
//        for (Integer seed : seeds) {
//            System.out.print(randomString(seed) + " ");
//        }

        Random random = new Random();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {

            int k = random.nextInt(100);
            k = current.nextInt(100);
            boolean add = hashSet.add(k);
        }
        System.out.println("hashSet.size() = " + hashSet.size());

    }

    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder builder = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            builder.append((char) ('`' + k));
        }
        return builder.toString();
    }

    public static long generateSeed(String goal, long start, long finish) {
        char[] input = goal.toCharArray();
        char[] pool = new char[input.length];
        label:
        for (long seed = start; seed < finish; seed++) {
            Random random = new Random(seed);

            for (int i = 0; i < input.length; i++)
                pool[i] = (char) (random.nextInt(27) + '`');

            if (random.nextInt(27) == 0) {
                for (int i = 0; i < input.length; i++) {
                    if (input[i] != pool[i])
                        continue label;
                }
                return seed;
            }
        }
        throw new NoSuchElementException("Sorry :/");
    }

}
