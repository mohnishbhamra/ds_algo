package com.rewindFast;

import java.math.*;

public class BigIntegerStudy {
    public static void main(String args[]){
        String number1 ="123123123";
        BigInteger bigInteger1 = new BigInteger(number1);
        BigInteger bigInteger2 = new BigInteger("6189461928461892459124");
        System.out.println("multiplication ->"+bigInteger1.multiply(bigInteger2));
        System.out.println("add ->"+bigInteger1.add(bigInteger2));
        System.out.println("sub->"+bigInteger1.subtract(bigInteger2));
        System.out.println("max->"+bigInteger1.max(bigInteger2));
        System.out.println("min->"+bigInteger1.min(bigInteger2));
        long val = bigInteger1.longValue();
        System.out.println(val);
    }
}
