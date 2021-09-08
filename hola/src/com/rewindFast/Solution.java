package com.rewindFast;

// you can also use imports, for example:

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] arr) {
        // write your code in Java SE 8
        Arrays.sort(arr);
        return ++arr[arr.length - 1];
    }
}

