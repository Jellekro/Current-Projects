package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    private static ArrayList<Integer> primes;

    public static void main(String[] args) {
        primes = new ArrayList<>();
      /*try {
            System.out.println(isPrime(-1) == false);
        } catch (IllegalArgumentException e) {
            System.out.println("Prime numbers cannot be negative, please enter a positive integer.");
        }
        System.out.println(isPrime(0) == false);
        System.out.println(isPrime(1) == false);
        System.out.println(isPrime(2) == true);
        System.out.println(isPrime(3) == true);*/
        System.out.println(isPrime(4) == false);
        System.out.println(isPrime(9) == false);
        System.out.println(isPrime(103) == true);
        System.out.println(isPrime(1301081) == true);
    }

    //returns true if natural x is prime, false otherwise
    public static boolean isPrime(int x) {
        //filters negatives (illegal input) as well as 0 & 1 which aren't primes by definition
        if (x < 0) {
            throw new IllegalArgumentException("Your input was negative.");
        } else if (x == 0 || x == 1) {
            System.out.println("By definition, 0 & 1 aren't prime numbers.");
            return false;
        } else {
            //sqrt x because any higher factor would have an already found complement; 2 is next int to check after 1
            return checkNext((int) Math.floor(Math.sqrt(x)), 2);
        }
    }

    private static boolean checkNext(int sqrtX, int next) {
        int last = 0;
        if (sqrtX < next) {
            return true;
        } else {
            for (Integer i : primes) {
                if (next % i == 0) {
                    return false;
                }
            }
            if (!primes.isEmpty()) {
                last = primes.get(primes.size()-1);
            }
            for (int i = last; i < sqrtX; i++) {
                if (next % i == 0) {
                    return false;
                }
            }
            primes.add(next);
            return checkNext(sqrtX, next+1);
        }
    }
}
