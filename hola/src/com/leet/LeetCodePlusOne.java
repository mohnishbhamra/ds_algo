package com.leet;

import java.util.ArrayList;
import java.util.List;


public class LeetCodePlusOne {
    int MIN_CARRY = 1;
    int MAX_CARRY = 9;
    int MAX_DECIMAL = 10;

    public int[] plusOne(int[] digits) {
        List<Integer> list = init(digits);
        return getResult(solve(list));
    }

    List<Integer> solve(List<Integer> list) {
        int carry = MIN_CARRY;
        for (int i = list.size() - 1; (i >= 0) && (carry == MIN_CARRY); i--) {
            Integer digit = list.get(i);
            digit = digit + carry;
            if (digit > 9) {
                carry = digit % MAX_CARRY;
                digit = digit % MAX_DECIMAL;
            } else {
                carry = 0;
            }
            list.set(i, digit);
        }

        if (carry == MIN_CARRY) {
            list.add(0, carry);
        }
        return list;
    }

    List<Integer> init(int[] digits) {
        List<Integer> list = new ArrayList<>();
        for (int i : digits) {
            list.add(i);
        }
        return list;
    }

    int[] getResult(List<Integer> list) {
        int[] result = new int[list.size()];
        int i = 0;
        for (int x : list) {
            result[i++] = x;
        }
        return result;
    }
}

