package com.blah;

import java.math.BigInteger;

public class Solution3 {
    public int nextPrime(int num) {

        return -1;
    }

    public boolean isPerfectSquare(int input) {

        //int mid=input/2;
        int num=1;
        int val=1;
        do{
            val = num*num;
            if(input%num==0){
                return true;
            }
            num++;
        }
        while (val<input);

        return false;
    }
}
